package com.bugmaker.util;

import com.bugmaker.entity.Orders;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;

public class HttpConnection {
    HttpServletRequest _request;
    HttpServletResponse _response;
    private Orders orders;
    public void getObject(HttpServletRequest request,
                            HttpServletResponse response) {
        _request = request;
        _response = response;
        System.out.println("正在接收");
    }

    //发JSONObject
    public void sendObject(Object send_object) {
        try {
            _response.setContentType("application/json; charset=utf-8");
            PrintWriter writer = _response.getWriter();
            System.out.println("-----发送分割线------");
            System.out.println(send_object);
            String strJson = JsonUtil.createJsonString(send_object);
            System.out.println(strJson);
            //通过PrintWriter返回给客户端操作结果

            writer.print(strJson);
            writer.flush();
            System.out.println("发送成功");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //发JSONArray
    public void sendArrayObejct(Object send_object){
        try {
            _response.setContentType("application/json; charset=utf-8");
            PrintWriter writer = _response.getWriter();
            System.out.println("-----发送分割线------");
            System.out.println(send_object);
            //通过PrintWriter返回给客户端操作结果
            writer.print(send_object);
            writer.flush();
            System.out.println("发送成功");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
