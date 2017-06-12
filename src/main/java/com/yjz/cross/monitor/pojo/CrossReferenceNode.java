package com.yjz.cross.monitor.pojo;

public class CrossReferenceNode
{
    private String address;
    
    private String serviceName;
    
    private CrossServiceNode serviceNode;
    
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

    public CrossServiceNode getServiceNode()
    {
        return serviceNode;
    }

    public void setServiceNode(CrossServiceNode serviceNode)
    {
        this.serviceNode = serviceNode;
    }
    
    
}
