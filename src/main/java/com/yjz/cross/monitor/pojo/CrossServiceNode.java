package com.yjz.cross.monitor.pojo;

import java.util.List;

public class CrossServiceNode
{
    private String address;
    
    private String serviceName;
    
    private List<CrossReferenceNode> nodeList;

    public String getAddress()
    {
        return address;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public String getServiceName()
    {
        return serviceName;
    }

    public void setServiceName(String serviceName)
    {
        this.serviceName = serviceName;
    }

    public List<CrossReferenceNode> getNodeList()
    {
        return nodeList;
    }

    public void setNodeList(List<CrossReferenceNode> nodeList)
    {
        this.nodeList = nodeList;
    }

}
