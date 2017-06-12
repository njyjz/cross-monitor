package com.yjz.cross.monitor.pojo;

import java.util.List;

public class CrossService
{
    private String serviceName;
    
    private List<CrossServiceNode> nodeList;

    public String getServiceName()
    {
        return serviceName;
    }

    public void setServiceName(String serviceName)
    {
        this.serviceName = serviceName;
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
