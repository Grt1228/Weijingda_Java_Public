package com.jgsu.utils;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

/**
 * 描述:
 * 格式化时间工具类
 *
 * @author grt
 * @create 2018-02-02 23:18
 */
public class PropertiesUtil {
    private static Logger logger = LoggerFactory.getLogger(PropertiesUtil.class);
    //常量
    private static Properties properties;

    //在tomcat启动时，类被ClassLoader记载，所以用静态代码块
    static{
        String fileName = "jgsu.properties";
        properties = new Properties();
        try {
            properties.load(new InputStreamReader(PropertiesUtil.class.getClassLoader().getResourceAsStream(fileName),
                    "UTF-8"));
        } catch (IOException e) {
            logger.error("配置文件读取异常",e);
        }
    }

    /**
     * 通过key获取properties中的对应的value
     * @param key
     * @return
     */
    public static String getProperty(String key){
        String value = properties.getProperty(key.trim());
        if(StringUtils.isBlank(value)){
            return null;
        }
        return value.trim();
    }

    public static String getProperty(String key,String defaultVale){
        String value = properties.getProperty(key.trim());
        if(StringUtils.isBlank(value)){
            return defaultVale;
        }
        return value.trim();
    }
}