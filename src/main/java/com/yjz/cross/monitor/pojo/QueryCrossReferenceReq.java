package com.yjz.cross.monitor.pojo;

public class QueryCrossReferenceReq
{
    private String registryName;
    
    private String crossReferenceName;
    
    private String nodeIP;

    public String getRegistryName()
    {
        return registryName;
    }

    public void setRegistryName(String registryName)
    {
        this.registryName = registryName;
    }

    public String getCrossReferenceName()
    {
        return crossReferenceName;
    }

    public void setCrossReferenceName(String crossReferenceName)
    {
        this.crossReferenceName = crossReferenceName;
    }

    public String getNodeIP()
    {
        return nodeIP;
    }

    public void setNodeIP(String nodeIP)
    {
        this.nodeIP = nodeIP;
    }
    
    
    
}
