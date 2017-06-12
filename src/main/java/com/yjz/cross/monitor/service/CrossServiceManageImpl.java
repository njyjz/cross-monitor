package com.yjz.cross.monitor.service;

import java.util.List;

import com.yjz.cross.monitor.pojo.AccessLog;
import com.yjz.cross.monitor.pojo.CrossService;
import com.yjz.cross.monitor.pojo.QueryCrossServiceReq;

public class CrossServiceManageImpl implements CrossServiceManage
{

    @Override
    public List<CrossService> queryCrossServices(QueryCrossServiceReq req)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<AccessLog> queryAccessRecord(String referenceNode, String serviceNode)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int delSeriveNode(String serviceNodeAddr)
    {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public String queryServiceNodeStatus(String serviceNodeAddr)
    {
        // TODO Auto-generated method stub
        return "";
    }
    
}
