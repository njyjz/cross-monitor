package com.yjz.cross.monitor.pojo;

public class AccessLog
{
    private String requestId;
    
    private String reqJson;
    
    private String respJson;
    
    private long costTimeMills;

    public String getRequestId()
    {
        return requestId;
    }

    public void setRequestId(String requestId)
    {
        this.requestId = requestId;
    }

    public String getReqJson()
    {
        return reqJson;
    }

    public void setReqJson(String reqJson)
    {
        this.reqJson = reqJson;
    }

    public String getRespJson()
    {
        return respJson;
    }

    public void setRespJson(String respJson)
    {
        this.respJson = respJson;
    }

    public long getCostTimeMills()
    {
        return costTimeMills;
    }

    public void setCostTimeMills(long costTimeMills)
    {
        this.costTimeMills = costTimeMills;
    } 
}
