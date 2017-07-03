package com.yjz.cross.monitor.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yjz.cross.monitor.model.AccessLogData;
import com.yjz.cross.monitor.pojo.AccessLog;

public interface AccessLogDataMapper
{
    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table access_log_data
     * @mbggenerated  Mon Jul 03 13:49:55 CST 2017
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table access_log_data
     * @mbggenerated  Mon Jul 03 13:49:55 CST 2017
     */
    int insert(AccessLogData record);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table access_log_data
     * @mbggenerated  Mon Jul 03 13:49:55 CST 2017
     */
    int insertSelective(AccessLogData record);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table access_log_data
     * @mbggenerated  Mon Jul 03 13:49:55 CST 2017
     */
    AccessLogData selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table access_log_data
     * @mbggenerated  Mon Jul 03 13:49:55 CST 2017
     */
    int updateByPrimaryKeySelective(AccessLogData record);

    /**
     * This method was generated by MyBatis Generator. This method corresponds to the database table access_log_data
     * @mbggenerated  Mon Jul 03 13:49:55 CST 2017
     */
    int updateByPrimaryKey(AccessLogData record);

    List<AccessLogData> selectByServerClientAddrees(@Param("serverAddress") String serverAddress,
        @Param("clientAddress") String clientAddress);
    
    int insert(AccessLog accessLog);
}