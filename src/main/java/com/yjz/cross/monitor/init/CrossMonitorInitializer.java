package com.yjz.cross.monitor.init;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import com.yjz.cross.config.Configuration;

/**
 * @ClassName CrossMonitorInitializer
 * @Description ³õÊ¼»¯CrossMonitor
 * @author biw
 * @Date Jun 12, 2017 9:48:06 AM
 * @version 1.0.0
 */
@Component
public class CrossMonitorInitializer implements ApplicationContextAware
{
    private static final Logger logger = LoggerFactory.getLogger(CrossMonitorInitializer.class);
    @Value("#{cross['registries']}")
    private String registries;
    
    public static Configuration CONF;
    
    @Override
    public void setApplicationContext(ApplicationContext applicationContext)
        throws BeansException
    {
        if(registries == null)
        {
            logger.error("there is no registries property configured in cross.properties.");
            return;
        }
        
        logger.info("Start loading registries in cross.properties.");
        String[] registryStrArr = registries.split(";");
        for(String registryStr : registryStrArr)
        {
            String[] nameAndAddr = registryStr.split("=");
            if(nameAndAddr.length > 1)
            {
                CONF.addRegistry(nameAndAddr[0], nameAndAddr[1]);   
            }
        }
        logger.info("Finished loading registries in cross.properties.");
    }
}
