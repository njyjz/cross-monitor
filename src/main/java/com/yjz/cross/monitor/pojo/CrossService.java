package com.yjz.cross.monitor.pojo;

import java.util.List;

public class CrossService
{
    private String serviceName;
    
    private List<CrossServiceNode> subNodeList;
    
    

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
