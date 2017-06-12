package com.yjz.cross.monitor.pojo;

public enum ServiceNodeStatus
{
    VALID("active"),INVALID("inactive"),UNKNONW("unknown");
    
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
