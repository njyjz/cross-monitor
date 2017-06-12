package com.yjz.cross.monitor.pojo;

public class CommonResp
{
    /**
     * 响应状态码
     */
    private String respCode;
    
    /**
     * 响应状态信息
     */
    private String respMsg;
    
    /**
     * 响应信息
     */
    private Object result;
    
    public String getRespCode()
    {
        return respCode;
    }
    
    public void setRespCode(String respCode)
    {
        this.respCode = respCode;
    }
    
    public String getRespMsg()
    {
        return respMsg;
    }
    
    public void setRespMsg(String respMsg)
    {
        this.respMsg = respMsg;
    }
    
    public Object getResult()
    {
        return result;
    }
    
    public void setResult(Object result)
    {
        this.result = result;
    }
    
}
