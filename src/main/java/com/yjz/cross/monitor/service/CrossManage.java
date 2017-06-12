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
     * @Description 根据条件查询CrossService列表
     * @author biw
     * @param req
     * @return
     */
    public List<CrossService> queryCrossServices(QueryCrossServiceReq req);
    
    /**
     * @Description 查询crossReference对crossService的调用记录
     * @author biw
     * @param referenceNodeAddr
     * @param serviceNodeAddr
     * @return
     */
    public List<AccessLog> queryAccessRecord(String referenceNodeAddr, String serviceNodeAddr);
    
    /**
     * @Description 删除一个CrossService节点
     * @author biw
     * @param serviceName
     * @param serviceNodeAddr
     * @return
     */
    public int delServiceNode(String serviceName, String serviceNodeAddr);
    
    /**
     * 
     * @Description 检测CrossService节点的状态
     * @author biw
     * @param serviceNodeAddr
     * @return
     */
    public String detectServiceNodeStatus(String serviceNodeAddr);
    
    /**
     * 
     * @Description 根据条件查询CrossReference列表
     * @author biw
     * @param req
     * @return
     */
    public List<CrossReference> queryCrossReferences(QueryCrossReferenceReq req);
}
