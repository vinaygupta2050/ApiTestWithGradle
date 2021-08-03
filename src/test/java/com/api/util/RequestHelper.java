package com.api.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

/**
 * @author in-vinaykumar.gupta on 01/08/21
 * @project IntelliJ IDEA
 */
public class RequestHelper {
    public static String getJsonString(Object o) {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.getSerializationConfig().withSerializationInclusion(JsonInclude.Include.NON_NULL);
        try {
            return objectMapper.writeValueAsString(o);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }
}
