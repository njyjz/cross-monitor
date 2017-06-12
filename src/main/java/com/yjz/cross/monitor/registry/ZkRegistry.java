package com.yjz.cross.monitor.registry;

import java.io.IOException;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.ReentrantLock;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.yjz.cross.CrossException;
import com.yjz.cross.monitor.init.CrossMonitorInitializer;

/**
 * 
 * @ClassName ZkRegistry
 * @Description
 * @author biw
 * @Date 2017.5.16 02:49:54
 * @version 1.0.0
 */
public class ZkRegistry implements Registry
{
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    
    private static final String ROOT_NODE_PATH = "/cross";
    
    private static final String REFERENCE_ROOT_NODE_PATH = "/cross-reference";
    
    private String registryName = null;
    
    private volatile ZooKeeper zk = null;
    
    ReentrantLock lock = new ReentrantLock();
    
    private CountDownLatch latch = new CountDownLatch(1);
    
    private String zkAddress;
    
    protected ZkRegistry(String registryName)
    {
        this.registryName = registryName;
        this.zkAddress = CrossMonitorInitializer.CONF.getRegistryAddress(registryName);
    }
    
    public void regist(String serviceName)
    {
        if (zk == null)
        {
            try
            {
                lock.lock();
                
                if (zk == null)
                {
                    connectZk();
                }
            }
            finally
            {
                lock.unlock();
                
            }
        }
    }
    
    /**
     * @Description
     * @author biw
     */
    private void connectZk()
    {
        if (zkAddress == null)
        {
            logger.error("'zk.address' is not configured in 'application.properties'!");
            throw new CrossException("'zk.address' is not configured in 'application.properties'!");
        }
        
        //
        if (isZkConnected())
        {
            return;
        }
        
        try
        {
            logger.info("Cross server connecting to zkServer " + zkAddress);
            
            zk = new ZooKeeper(zkAddress, 8000, new Watcher()
            {
                
                @Override
                public void process(WatchedEvent event)
                {
                    if (event.getState() == Event.KeeperState.SyncConnected)
                    {
                        logger.info("Cross server connected to zkServer " + zkAddress);
                        latch.countDown();
                    }
                }
            });
            
            latch.await();
        }
        catch (IOException | InterruptedException e)
        {
            logger.error(e.getMessage(), e);
            throw new CrossException(e);
        }
    }
    
    private boolean isZkConnected()
    {
        if (zk == null)
        {
            try
            {
                lock.lock();
                if (zk != null)
                {
                    return true;
                }
                return false;
            }
            finally
            {
                lock.unlock();
            }
        }
        
        return true;
    }
    
    @Override
    public List<String> queryAllSerivceNodes()
    {
        if (zk == null)
        {
            connectZk();
        }
        
        if (zk == null)
        {
            return new ArrayList<String>(0);
        }
        
        try
        {  
            Stat state = zk.exists(ROOT_NODE_PATH, false);
            if (state == null)
            {
                return new ArrayList<String>(0);
            }
            else
            {
                return zk.getChildren(ROOT_NODE_PATH, false);
            }
        }
        catch (KeeperException | InterruptedException e)
        {
            logger.error(e.getMessage(), e);
            throw new CrossException(e);
        }
    }
    
    public List<String> querySerivceNodes(String serviceName)
    {
        if (zk == null)
        {
            connectZk();
        }
        
        if (zk == null)
        {
            return new ArrayList<String>(0);
        }
        
        try
        {
            String serviceAddressPath = ROOT_NODE_PATH + "/" + serviceName;
            
            Stat state = zk.exists(serviceAddressPath, false);
            if (state == null)
            {
                return new ArrayList<String>(0);
            }
            else
            {
                return zk.getChildren(serviceAddressPath, false);
            }
        }
        catch (KeeperException | InterruptedException e)
        {
            logger.error(e.getMessage(), e);
            throw new CrossException(e);
        }
        
    }
    
    public List<String> queryReferenceNodesUnderServiceNode(String serviceName, String serviceAddr)
    {
        if (zk == null)
        {
            connectZk();
        }
        
        if (zk == null)
        {
            return new ArrayList<String>(0);
        }
        
        try
        {
            String serviceAddressPath = ROOT_NODE_PATH + "/" + serviceName + "/" + serviceAddr;
            
            Stat state = zk.exists(serviceAddressPath, false);
            if (state == null)
            {
                return new ArrayList<String>(0);
            }
            else
            {
                return zk.getChildren(serviceAddressPath, false);
            }
        }
        catch (KeeperException | InterruptedException e)
        {
            logger.error(e.getMessage(), e);
            throw new CrossException(e);
        }
    }
    
    @Override
    public List<String> queryAllReferenceNodes()
    {
        if (zk == null)
        {
            connectZk();
        }
        
        if (zk == null)
        {
            return new ArrayList<String>(0);
        }
        
        try
        {  
            Stat state = zk.exists(REFERENCE_ROOT_NODE_PATH, false);
            if (state == null)
            {
                return new ArrayList<String>(0);
            }
            else
            {
                return zk.getChildren(REFERENCE_ROOT_NODE_PATH, false);
            }
        }
        catch (KeeperException | InterruptedException e)
        {
            logger.error(e.getMessage(), e);
            throw new CrossException(e);
        }
    }
    
    @Override
    public List<String> queryReferenceNodes(String referenceName)
    {
        if (zk == null)
        {
            connectZk();
        }
        
        if (zk == null)
        {
            return new ArrayList<String>(0);
        }
        
        try
        {
            String referAddressPath = REFERENCE_ROOT_NODE_PATH + "/" + referenceName;
            
            Stat state = zk.exists(referAddressPath, false);
            if (state == null)
            {
                return new ArrayList<String>(0);
            }
            else
            {
                return zk.getChildren(referAddressPath, false);
            }
        }
        catch (KeeperException | InterruptedException e)
        {
            logger.error(e.getMessage(), e);
            throw new CrossException(e);
        }
        
    }

    @Override
    public List<String> queryServiceNodesUnderReferenceNode(String serviceName, String referenceAddr)
    {
        if (zk == null)
        {
            connectZk();
        }
        
        if (zk == null)
        {
            return new ArrayList<String>(0);
        }
        
        try
        {
            String serviceAddressPath = REFERENCE_ROOT_NODE_PATH + "/" + serviceName + "/" + referenceAddr;
            
            Stat state = zk.exists(serviceAddressPath, false);
            if (state == null)
            {
                return new ArrayList<String>(0);
            }
            else
            {
                return zk.getChildren(serviceAddressPath, false);
            }
        }
        catch (KeeperException | InterruptedException e)
        {
            logger.error(e.getMessage(), e);
            throw new CrossException(e);
        }
    }
    
    @Override
    public void delServiceNode(String serviceName, String serviceAddr)
    {
        if (zk == null)
        {
            connectZk();
        }
        
        if (zk == null)
        {
            return;
        }
        
        try
        {
            zk.delete(ROOT_NODE_PATH + "/" + serviceName + "/" + serviceAddr, -1);
        }
        catch (InterruptedException | KeeperException e)
        {
           logger.error(e.getMessage(), e);
            throw new CrossException(e);
        }
    }

    public static void main(String[] args)
        throws IOException, InterruptedException
    {
        
        CountDownLatch cd = new CountDownLatch(1);
        ZooKeeper zk = new ZooKeeper("localhost:2181", 8000, new Watcher()
        {
            
            @Override
            public void process(WatchedEvent event)
            {
                cd.countDown();
            }
            
        });
        
        cd.await();
        
        try
        {
            List<String> list = zk.getChildren(ROOT_NODE_PATH, false);
            for (String serv : list)
            {
                List<String> addrList = zk.getChildren(ROOT_NODE_PATH + "/" + serv, false);
                for (String addr : addrList)
                {
                    zk.delete(ROOT_NODE_PATH + "/" + serv + "/" + addr, -1);
                }
            }
        }
        catch (InterruptedException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        catch (KeeperException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
}
