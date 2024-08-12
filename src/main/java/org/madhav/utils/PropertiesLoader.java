package org.madhav.utils;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesLoader {
    public static Properties properties;

    static {
        properties = new Properties();
        try{
            InputStream inputStream = new FileInputStream("src/main/resources/config.properties");
            properties.load(inputStream);
        }catch (Exception e){
            System.out.println("Exception");
        }
    }

    public static String getValue(String key,String defaultValue){
        return properties.getProperty(key, defaultValue);
    }

    public static String getValue(String key){
        return properties.getProperty(key);
    }
}
