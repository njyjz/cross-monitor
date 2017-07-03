package com.yjz.cross.monitor.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yjz.cross.monitor.dao.AccessLogDataMapper;
import com.yjz.cross.monitor.model.AccessLogData;
import com.yjz.cross.monitor.pojo.AccessLog;
import com.yjz.cross.monitor.service.AccessLogService;
import com.yjz.cross.server.annotation.CrossService;

@Service
@CrossService
public class AccessLogServiceImpl implements AccessLogService
{
    @Resource
    private AccessLogDataMapper accessLogDataMapper;
    
    public int insert(AccessLog accessLog)
    {
        AccessLogData record = new AccessLogData();
        record.setRequestId(accessLog.getRequestId());
        record.setServerAddress(accessLog.getServerAddress());
        record.setClientAddress(accessLog.getClientAddress());
        record.setReqJson(accessLog.getReqJson());
        record.setRespJson(accessLog.getRespJson());
        record.setCostTimeMills((int)(accessLog.getCostTimeMills()));
        int num = accessLogDataMapper.insertSelective(record);
        return num;
    }
}
