package com.api.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author in-vinaykumar.gupta on 19/06/21
 * @project IntelliJ IDEA
 */
public class PropertyReader {
    Properties properties = new Properties();
    public PropertyReader() {
        loadProperties();
    }
    private void loadProperties() {
        try {
            String env = System.getProperty("env");
            System.out.println("ENV: " + env);
            System.out.println("ContentType: " + System.getProperty("contentType"));
            if (null == env) env = "dev";
            String propertiesFilePath = env + ".properties";
            InputStream inputStream = this
                    .getClass()
                    .getClassLoader()
                    .getResourceAsStream(propertiesFilePath);
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private String readProperty(String key) {
        return properties.getProperty(key);
    }
    public String getBookingUrlKey() {
        return readProperty("bookingUrl");
    }
}
