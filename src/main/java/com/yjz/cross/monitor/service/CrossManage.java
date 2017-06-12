package com.yjz.cross.monitor.service;

import java.util.List;

import com.yjz.cross.monitor.pojo.AccessLog;
import com.yjz.cross.monitor.pojo.CrossReference;
import com.yjz.cross.monitor.pojo.CrossService;
import com.yjz.cross.monitor.pojo.QueryCrossReferenceReq;
import com.yjz.cross.monitor.pojo.QueryCrossServiceReq;

public interface CrossManage
{
    /**
     * @Description 
     * @author biw
     * @param req
     * @return
     */
    public List<CrossService> queryCrossServices(QueryCrossServiceReq req);
    
    /**
     * @Description
     * @author biw
     * @param referenceNodeAddr
     * @param serviceNodeAddr
     * @return
     */
    public List<AccessLog> queryAccessRecord(String referenceNodeAddr, String serviceNodeAddr);
    
    /**
     * @Description
     * @author biw
     * @param serviceName
     * @param serviceNodeAddr
     * @return
     */
    public int delServiceNode(String serviceName, String serviceNodeAddr);
    
    /**
     * 
     * @Description̬
     * @author biw
     * @param serviceNodeAddr
     * @return
     */
    public String detectServiceNodeStatus(String serviceNodeAddr);
    
    /**
     * 
     * @Description
     * @author biw
     * @param req
     * @return
     */
    public List<CrossReference> queryCrossReferences(QueryCrossReferenceReq req);
}
