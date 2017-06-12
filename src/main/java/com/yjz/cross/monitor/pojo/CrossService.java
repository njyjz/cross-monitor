package com.yjz.cross.monitor.pojo;

import java.util.List;

public class CrossService
{
    private String serviceClassName;
    
    private List<CrossServiceNode> nodeList;
    
    

    public String getServiceName()
    {
        return serviceClassName;
    }

    public void setServiceName(String serviceName)
    {
        this.serviceClassName = serviceName;
    }

    public List<CrossServiceNode> getNodeList()
    {
        return nodeList;
    }

    public void setNodeList(List<CrossServiceNode> nodeList)
    {
        this.nodeList = nodeList;
    }
    
    
}
