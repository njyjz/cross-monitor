package com.yjz.cross.monitor.pojo;

public class QueryCrossServiceReq
{
    private String registryName;
    
    private String crossServiceName;
    
    private String nodeIP;

    public String getCrossServiceName()
    {
        return crossServiceName;
    }

    public void setCrossServiceName(String crossServiceName)
    {
        this.crossServiceName = crossServiceName;
    }

    public String getRegistryName()
    {
        return registryName;
    }

    public void setRegistryName(String registryName)
    {
        this.registryName = registryName;
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
