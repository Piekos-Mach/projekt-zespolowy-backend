package com.projekt_zespolowy.tablica_ogloszen.controllers.error;

import com.google.common.collect.Maps;

import java.util.Map;

public class ObjectErrorToFieldTranslatorService {

    private final Map<String, String> objectErrorToFieldError = Maps.newHashMap();

    /**
     * put(errorName, newNameForVid)
     */
    public ObjectErrorToFieldTranslatorService() {

        objectErrorToFieldError.put("", "");
    }

    public String translateObjectError(String objectError) {

        return objectErrorToFieldError.getOrDefault(objectError, objectError);
    }

}
