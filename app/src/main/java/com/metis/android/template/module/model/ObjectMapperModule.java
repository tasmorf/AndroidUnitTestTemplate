package com.metis.android.template.module.model;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ObjectMapperModule {

    private static ObjectMapper objectMapper;

    public static ObjectMapper objectMapper() {
        if(objectMapper == null) {
            objectMapper = new ObjectMapper();
            //do whatever kind of configuration to the mapper you want here
            objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        }
        return objectMapper;
    }
}
