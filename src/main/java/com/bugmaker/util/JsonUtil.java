package com.bugmaker.util;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class JsonUtil {
    //将对象转化为JSONObeject,并且返回字符串
    public static String createJsonString(Object object){
        JSONObject json= JSONObject.fromObject(object);
        return json.toString();
    }
    //将对象转化为JSONObeject
    public static JSONObject createJsonObject(Object object){
        JSONObject json=JSONObject.fromObject(object);
        return json;
    }
    //将object添加进JSONArray
    public static void createJsonArray(JSONArray jsonArray,Object object){
        jsonArray.add(object);
    }
}
