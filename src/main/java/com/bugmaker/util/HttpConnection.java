package com.bugmaker.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class HttpConnection {
    HttpServletRequest _request;
    HttpServletResponse _response;

    public String getObject(HttpServletRequest request,
                            HttpServletResponse response) {
        _request = request;
        _response = response;
        System.out.println("正在接受");
        String receive_object = request.getParameter("obj");
        System.out.println("接收到的值:" + receive_object);
        return receive_object;
    }
    public String getObjectOrder(HttpServletRequest request,
                            HttpServletResponse response) {
        _request = request;
        _response = response;

        System.out.println("正在接受");
        String receive_object = request.getParameter("obj");
        System.out.println("接收到的值:" + receive_object);
        return receive_object;
    }

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
}
