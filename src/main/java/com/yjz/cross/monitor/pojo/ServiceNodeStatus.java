package com.yjz.cross.monitor.pojo;

public enum ServiceNodeStatus
{
    VALID("active"),INVALID("inactive");
    
    private String status;
    
    private ServiceNodeStatus(String status)
    {
        this.status = status;
    }
    
    public String status()
    {
        return this.status;
    }
}
