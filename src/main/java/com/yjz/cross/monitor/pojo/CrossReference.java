package com.yjz.cross.monitor.pojo;

import java.util.List;

public class CrossReference
{
    private String serviceName;
    
    private List<CrossReferenceNode> subNodeList;

    public String getServiceName()
    {
        return serviceName;
    }

    public void setServiceName(String serviceName)
    {
        this.serviceName = serviceName;
    }

    public List<CrossReferenceNode> getSubNodeList()
    {
        return subNodeList;
    }

    public void setSubNodeList(List<CrossReferenceNode> subNodeList)
    {
        this.subNodeList = subNodeList;
    }
    
    
}
