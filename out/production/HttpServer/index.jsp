<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/10/13
  Time: 17:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
  String path = request.getContextPath();
  String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html>
  <head>
    <base href="<%=basePath%>">
    <title>$Title$</title>
  </head>
  <body>
  <a href="http://localhost:8070/HttpServer_war_exploded/http
">get请求1</a><br/>

  <a href="http">get请求2</a><hr/>
  <form method = "post" action="http">
    <input type="submit" value="提交"/>
  </form>

  </body>
</html>
