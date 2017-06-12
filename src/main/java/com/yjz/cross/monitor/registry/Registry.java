package com.yjz.cross.monitor.registry;

import java.util.List;

/**
 * @ClassName Registry
 * @Description
 * @author biw
 * @Date 20170516 02:47:56
 * @version 1.0.0
 */
public interface Registry
{
    /**
     * @Description 注册服务到注册中心
     * @author biw
     * @param serviceName
     */
    public void regist(String serviceName);
    
    public List<String> queryAllSerivceNodes();
    
    public List<String> querySerivceNodes(String serviceName);
    
    public List<String> queryReferenceNodesUnderServiceNode(String serviceName, String serviceAddr);
    
    public List<String> queryAllReferenceNodes();
    
    public List<String> queryReferenceNodes(String referenceName);
    
    public List<String> queryServiceNodesUnderReferenceNode(String serviceName, String referenceAddr);
    
    public void delServiceNode(String serviceName, String serviceAddr);
}
