package com.yjz.cross.monitor.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yjz.cross.monitor.pojo.AccessLog;
import com.yjz.cross.monitor.pojo.CrossReference;
import com.yjz.cross.monitor.pojo.CrossService;
import com.yjz.cross.monitor.pojo.QueryCrossReferenceReq;
import com.yjz.cross.monitor.pojo.QueryCrossServiceReq;
import com.yjz.cross.monitor.service.CrossManage;

/**
 * @ClassName CrossServiceManageController
 * @Description
 * @author biw
 * @Date Jun 12, 2017 9:20:31 AM
 * @version 1.0.0
 */
@Controller
@RequestMapping("/")
public class CrossManageController
{
    @Resource
    private CrossManage crossManage;
    
    /**
     * @Description 
     * @author biw
     * @param req
     * @return
     */
    @RequestMapping("/queryCrossServices.do")
    @ResponseBody
    public List<CrossService> queryCrossServices(@RequestBody QueryCrossServiceReq req)
    {
        return crossManage.queryCrossServices(req);
    }
    
    /**
     * @Description
     * @author biw
     * @param serviceName
     * @param serviceNodeAddr
     * @return
     */
    @RequestMapping("/delServiceNode.do")
    @ResponseBody
    public int delServiceNode(String serviceName, String serviceNodeAddr)
    {
        return crossManage.delServiceNode(serviceName, serviceNodeAddr);
    }
    
    /**
     * 
     * @Description̬
     * @author biw
     * @param serviceNodeAddr
     * @return
     */
    @RequestMapping("/detectServiceNodeStatus.do")
    @ResponseBody
    public String detectServiceNodeStatus(String serviceNodeAddr)
    {
        return crossManage.detectServiceNodeStatus(serviceNodeAddr);
    }
    
    /**
     * 
     * @Description
     * @author biw
     * @param req
     * @return
     */
    @RequestMapping("/queryCrossReferences.do")
    @ResponseBody
    public List<CrossReference> queryCrossReferences(@RequestBody QueryCrossReferenceReq req)
    {
        return crossManage.queryCrossReferences(req);
    }
    
    /**
     * @Description
     * @author biw
     * @param referenceNodeAddr
     * @param serviceNodeAddr
     * @return
     */
    @RequestMapping("/queryAccessRecord.do")
    @ResponseBody
    public List<AccessLog> queryAccessRecord(String referenceNodeAddr, String serviceNodeAddr)
    {
        return crossManage.queryAccessRecord(referenceNodeAddr, serviceNodeAddr);
    }
}
