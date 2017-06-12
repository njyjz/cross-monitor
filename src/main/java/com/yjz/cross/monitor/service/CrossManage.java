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
     * @Description ����������ѯCrossService�б�
     * @author biw
     * @param req
     * @return
     */
    public List<CrossService> queryCrossServices(QueryCrossServiceReq req);
    
    /**
     * @Description ��ѯcrossReference��crossService�ĵ��ü�¼
     * @author biw
     * @param referenceNodeAddr
     * @param serviceNodeAddr
     * @return
     */
    public List<AccessLog> queryAccessRecord(String referenceNodeAddr, String serviceNodeAddr);
    
    /**
     * @Description ɾ��һ��CrossService�ڵ�
     * @author biw
     * @param serviceName
     * @param serviceNodeAddr
     * @return
     */
    public int delServiceNode(String serviceName, String serviceNodeAddr);
    
    /**
     * 
     * @Description ���CrossService�ڵ��״̬
     * @author biw
     * @param serviceNodeAddr
     * @return
     */
    public String detectServiceNodeStatus(String serviceNodeAddr);
    
    /**
     * 
     * @Description ����������ѯCrossReference�б�
     * @author biw
     * @param req
     * @return
     */
    public List<CrossReference> queryCrossReferences(QueryCrossReferenceReq req);
}
