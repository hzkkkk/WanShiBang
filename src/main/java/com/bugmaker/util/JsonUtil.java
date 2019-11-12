package com.bugmaker.util;

import net.sf.json.JSONObject;

public class JsonUtil {
    public static String createJsonString(Object object){
        JSONObject json= JSONObject.fromObject(object);
        return json.toString();
    }
    public static JSONObject createJsonObject(Object object){
        JSONObject json=JSONObject.fromObject(object);
        return json;
    }
}
