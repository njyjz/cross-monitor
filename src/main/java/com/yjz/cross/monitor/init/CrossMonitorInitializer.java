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
 * @Description CrossMonitor
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
    
    public static Configuration CONF = new Configuration();
    
    @Override
    public void setApplicationContext(ApplicationContext applicationContext)
        throws BeansException
    {
        if (registries == null)
        {
            logger.error("there is no registries property configured in cross.properties.");
            return;
        }
        
        logger.info("Start loading registries in cross.properties.");
        String[] registryStrArr = registries.split(";");
        for (String registryStr : registryStrArr)
        {
            int lbIdx = registryStr.indexOf("(");
            int rbIdx = registryStr.indexOf(")");
            
            String name = registryStr.substring(0, lbIdx);
            String value = registryStr.substring(lbIdx + 1, rbIdx);
            
            CONF.addRegistry(name, value);
        }
        logger.info("Finished loading registries in cross.properties.");
    }
}
