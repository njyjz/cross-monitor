package com.yjz.cross.monitor.pojo;

import java.util.List;

public class CrossReferenceNode
{
    private String address;
    
    private String serviceName;
    
    private List<CrossServiceNode> subNodeList ;
    
    public CrossReferenceNode()
    {
        
    }
    
    public CrossReferenceNode(String serviceName, String address)
    {
        this.serviceName = serviceName;
        this.address = address;
    }

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

    public List<CrossServiceNode> getSubNodeList()
    {
        return subNodeList;
    }

    public void setSubNodeList(List<CrossServiceNode> subNodeList)
    {
        this.subNodeList = subNodeList;
    }
    
    
}
