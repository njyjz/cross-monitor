package com.yjz.cross.monitor.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.yjz.cross.monitor.pojo.AccessLog;
import com.yjz.cross.monitor.pojo.CrossReference;
import com.yjz.cross.monitor.pojo.CrossReferenceNode;
import com.yjz.cross.monitor.pojo.CrossService;
import com.yjz.cross.monitor.pojo.CrossServiceNode;
import com.yjz.cross.monitor.pojo.QueryCrossReferenceReq;
import com.yjz.cross.monitor.pojo.QueryCrossServiceReq;
import com.yjz.cross.monitor.registry.Registry;
import com.yjz.cross.monitor.registry.RegistryFactory;

/**
 * 
 * @ClassName CrossServiceManageImpl
 * @Description TODO(这里用一句话描述这个类的作用)
 * @author biw
 * @Date Jun 12, 2017 9:16:39 AM
 * @version 1.0.0
 */
@Service
public class CrossManageImpl implements CrossManage
{

    @Override
    public List<CrossService> queryCrossServices(QueryCrossServiceReq req)
    {
        Registry registry = RegistryFactory.instance().getRegistry(req.getRegistryName());
        List<CrossService> serviceNodeList = new ArrayList<>();
        
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
            List<CrossServiceNode> nodeList = new ArrayList<>();   
            for (String addr : serviceAddrList)
            {
                CrossServiceNode node = new CrossServiceNode(serviceName, addr);
                nodeList.add(node);
                
                List<String> referenceAddrList =
                    registry.queryReferenceNodesUnderServiceNode(serviceName, addr);
                List<CrossReferenceNode> referNodeList =
                    convReferenceAddrToNode(serviceName, referenceAddrList);
                node.setReferenceNodeList(referNodeList);
            }
            
            CrossService crossService = new CrossService();
            crossService.setServiceName(serviceName);   
            crossService.setNodeList(nodeList);
            
            serviceNodeList.add(crossService);
        }

        return serviceNodeList;
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
    
    @Override
    public List<CrossReference> queryCrossReferences(QueryCrossReferenceReq req)
    {
        Registry registry = RegistryFactory.instance().getRegistry(req.getRegistryName());
        List<CrossReference> referenceList = new ArrayList<>();
        
        List<String> referNameList = null;
        if(req.getCrossReferenceName() != null)
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
            CrossReference crossReference = new CrossReference();
            
            
            List<String> referAddrList = registry.queryReferenceNodes(referName);
            List<CrossReferenceNode> referNodeList = convReferenceAddrToNode(referName, referAddrList);
            for(CrossReferenceNode referNode : referNodeList)
            {
                List<String> serviceAddrList = registry.queryReferenceNodesUnderServiceNode(referName, referNode.getAddress());
                if(serviceAddrList != null && !serviceAddrList.isEmpty())
                {
                    CrossServiceNode serviceNode = new CrossServiceNode(referName, serviceAddrList.get(0));
                    referNode.setServiceNode(serviceNode);
                }      
            }
            
            crossReference.setReferenceNodeList(referNodeList);
            crossReference.setServiceName(referName);
            referenceList.add(crossReference);
            
        }
        return referenceList;
    }
    
    @Override
    public List<AccessLog> queryAccessRecord(String referenceNode, String serviceNode)
    {
        // TODO Auto-generated method stub
        return null;
    }
    
    @Override
    public int delServiceNode(String serviceName, String serviceNodeAddr)
    {
        Registry registry = RegistryFactory.instance().getRegistry(serviceName);
        registry.delServiceNode(serviceName, serviceNodeAddr);
        return 1;
    }
    
    @Override
    public String detectServiceNodeStatus(String serviceNodeAddr)
    {
        // TODO Auto-generated method stub
        return "";
    }
    
    
    
}
