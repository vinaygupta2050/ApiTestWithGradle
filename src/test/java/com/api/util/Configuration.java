package com.api.util;

/**
 * @author in-vinaykumar.gupta on 19/06/21
 * @project IntelliJ IDEA
 */
public class Configuration {
    private static Configuration configuration;
    private final PropertyReader propertiesReader;
    private Configuration() {
        propertiesReader = new PropertyReader();
    }
    public static synchronized  Configuration getConfiguration(){
        if(configuration==null)
        {
            configuration=new Configuration();
        }
        return configuration;
    }
    public String getBookingUrl(){
        return propertiesReader.getBookingUrlKey();
    }
}
