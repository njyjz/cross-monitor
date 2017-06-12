package com.yjz.cross.monitor.service;

import java.util.List;

import com.yjz.cross.monitor.pojo.AccessLog;
import com.yjz.cross.monitor.pojo.CrossService;
import com.yjz.cross.monitor.pojo.QueryCrossServiceReq;

public interface CrossServiceManage
{
    public List<CrossService> queryCrossServices(QueryCrossServiceReq req);
    
    public List<AccessLog> queryAccessRecord(String referenceNodeAddr, String serviceNodeAddr);
    
    public int delSeriveNode(String serviceNodeAddr);
    
    public String queryServiceNodeStatus(String serviceNodeAddr);
}
