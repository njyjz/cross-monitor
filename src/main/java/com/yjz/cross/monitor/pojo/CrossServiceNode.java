package com.yjz.cross.monitor.pojo;

import java.util.List;

public class CrossServiceNode
{
    private String address;
    
    private String serviceName;
    
    private String status = ServiceNodeStatus.UNKNONW.status();
    
    private List<CrossReferenceNode> referenceNodeList;
    
    public CrossServiceNode()
    {
        
    }
    
    public CrossServiceNode(String serviceName, String address)
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

    public List<CrossReferenceNode> getReferenceNodeList()
    {
        return referenceNodeList;
    }

    public void setReferenceNodeList(List<CrossReferenceNode> nodeList)
    {
        this.referenceNodeList = nodeList;
    }

    public String getStatus()
    {
        return status;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }

}
