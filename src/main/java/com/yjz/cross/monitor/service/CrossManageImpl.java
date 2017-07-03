package com.yjz.cross.monitor.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.yjz.cross.codec.RpcDecoder;
import com.yjz.cross.codec.RpcEncoder;
import com.yjz.cross.codec.RpcResponse;
import com.yjz.cross.monitor.pojo.AccessLog;
import com.yjz.cross.monitor.pojo.CrossReference;
import com.yjz.cross.monitor.pojo.CrossReferenceNode;
import com.yjz.cross.monitor.pojo.CrossService;
import com.yjz.cross.monitor.pojo.CrossServiceNode;
import com.yjz.cross.monitor.pojo.QueryCrossReferenceReq;
import com.yjz.cross.monitor.pojo.QueryCrossServiceReq;
import com.yjz.cross.monitor.pojo.ServiceNodeStatus;
import com.yjz.cross.monitor.registry.Registry;
import com.yjz.cross.monitor.registry.RegistryFactory;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;

/**
 * 
 * @ClassName CrossServiceManageImpl
 * @Description 
 * @author biw
 * @Date Jun 12, 2017 9:16:39 AM
 * @version 1.0.0
 */
@Service
public class CrossManageImpl implements CrossManage
{
    private static final Logger logger = LoggerFactory.getLogger(CrossManageImpl.class);
    
    @Override
    public List<CrossService> queryCrossServices(QueryCrossServiceReq req)
    {
        Registry registry = RegistryFactory.instance().getRegistry();
        List<CrossService> CrossServiceList = new ArrayList<>();
        
        List<String> serviceList = null;
        if(req.getCrossServiceName() == null)
        {
            serviceList = registry.queryAllSerivceNodes();
        }
        else
        {
            serviceList = new ArrayList<String>();
            serviceList.add(req.getCrossServiceName());
        }
        
        for(String serviceName : serviceList)
        { 
            List<String> serviceAddrList = registry.querySerivceNodes(serviceName);
            if(serviceAddrList.isEmpty())
            {
                continue;
            }
            
            List<CrossServiceNode> nodeList = new ArrayList<>();   
            for (String addr : serviceAddrList)
            {
                CrossServiceNode node = new CrossServiceNode(serviceName, addr);
                nodeList.add(node);
                
                List<String> referenceAddrList =
                    registry.queryClientsUnderServer(serviceName, addr);
                List<CrossReferenceNode> referNodeList =
                    convReferenceAddrToNode(serviceName, referenceAddrList);
                node.setReferenceNodeList(referNodeList);
            }

            CrossService crossService = new CrossService();
            crossService.setServiceName(serviceName);   
            crossService.setNodeList(nodeList);
            CrossServiceList.add(crossService);
        }

        return CrossServiceList;
    }
    
    private List<CrossReferenceNode> convReferenceAddrToNode(String serviceName, List<String> referenceAddrList)
    {
        List<CrossReferenceNode> referNodeList = new ArrayList<>();
        for (String addr : referenceAddrList)
        {
            CrossReferenceNode node = new CrossReferenceNode(serviceName, addr);
            referNodeList.add(node);
        }
        
        return referNodeList;
    }
    
    private List<CrossServiceNode> convServiceAddrToNode(String serviceName, List<String> serviceAddrList)
    {
        List<CrossServiceNode> serviceNodeList = new ArrayList<>();
        for (String addr : serviceAddrList)
        {
            CrossServiceNode node = new CrossServiceNode(serviceName, addr);
            serviceNodeList.add(node);
        }
        
        return serviceNodeList;
    }
    
    
    @Override
    public List<CrossReference> queryCrossReferences(QueryCrossReferenceReq req)
    {
        Registry registry = RegistryFactory.instance().getRegistry();
        List<CrossReference> referenceList = new ArrayList<>();
        
        List<String> referNameList = null;
        if(req.getCrossReferenceName()== null)
        {
            referNameList = registry.queryAllReferenceNodes();
        }
        else
        {
            referNameList = new ArrayList<>();
            referNameList.add(req.getCrossReferenceName());
        }
        
        for(String referName : referNameList)
        {
            List<String> clientAddrList = registry.queryClientNodes(referName);
            List<CrossReferenceNode> referNodeList = convReferenceAddrToNode(referName, clientAddrList);
            for(CrossReferenceNode referNode : referNodeList)
            {
                List<String> serviceAddrList = registry.queryServersUnderClient(referName, referNode.getAddress());
                List<CrossServiceNode> serviceNodeList = convServiceAddrToNode(referName, serviceAddrList);
                referNode.setSubNodeList(serviceNodeList);      
            }
            
            CrossReference crossReference = new CrossReference();
            crossReference.setSubNodeList(referNodeList);
            crossReference.setServiceName(referName);
            referenceList.add(crossReference);
            
        }
        return referenceList;
    }
    
    @Override
    public List<AccessLog> queryAccessRecord(String serverAddress, String clientAddress)
    {
        // TODO 
        return new ArrayList<>();
    }
    
    @Override
    public int delServiceNode(String serviceName, String serverAddr)
    {
        Registry registry = RegistryFactory.instance().getRegistry(serviceName);
        registry.delServiceNode(serviceName, serverAddr);
        return 1;
    }
    
    @Override
    public String detectServiceNodeStatus(String serverAddr)
    {
        CountDownLatch latch = new CountDownLatch(1);
        AtomicBoolean connected = new AtomicBoolean(false);
        
        EventLoopGroup group = new NioEventLoopGroup();
        try
        {
            Bootstrap b = new Bootstrap();
            b.group(group).channel(NioSocketChannel.class).option(ChannelOption.TCP_NODELAY, true).handler(
                new ChannelInitializer<SocketChannel>()
                {
                    @Override
                    public void initChannel(SocketChannel ch)
                        throws Exception
                    {
                        ChannelPipeline cp = ch.pipeline();
                        
                        cp.addLast(new RpcEncoder());
                        cp.addLast(new LengthFieldBasedFrameDecoder(Integer.MAX_VALUE, 0, 4, 0, 0));
                        cp.addLast(new RpcDecoder(RpcResponse.class));
                        //cp.addLast(new ClientHandler());
                    }
                });
                
            // Start the client.
            String[] args = serverAddr.split(":");
            System.out.println("'netty connect to " + args[0] + ":" + args[1]);
            ChannelFuture channelFuture = b.connect(args[0], Integer.parseInt(args[1])).sync();
            
            channelFuture.addListener(new ChannelFutureListener()
            {
                @Override
                public void operationComplete(final ChannelFuture channelFuture)
                    throws Exception
                {
                    if (channelFuture.isSuccess())
                    {
                        logger.info("Successfully connect to remote server. remote peer = " + serverAddr);
                        connected.set(true);
                    }
                    else
                    {
                        logger.error("Failed connect to remote server. remote peer = " + serverAddr);
                        connected.set(false);
                    }

                    latch.countDown();
                }
            });
            
            latch.await();
            
            return connected.get() ? ServiceNodeStatus.VALID.status() : ServiceNodeStatus.INVALID.status();
        }
        catch (Exception e)
        {
            if (latch != null)
            {
                latch.countDown();
            }
            logger.error(e.getMessage(), e);
            return ServiceNodeStatus.INVALID.status();
        }
        finally
        {
            group.shutdownGracefully();
        }

    }
    
    
    
}
