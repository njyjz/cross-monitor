package com.yjz.cross.monitor.pojo;

import java.util.List;

public class CrossReference
{
    private String serviceName;
    
    private List<CrossReferenceNode> referenceNodeList;

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
    
    
}
