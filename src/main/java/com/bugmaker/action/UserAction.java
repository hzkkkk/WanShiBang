package com.bugmaker.action;

import com.bugmaker.entity.User;
import com.bugmaker.service.UserService;
import com.bugmaker.util.EntityToJsonUtil;
import com.bugmaker.util.HttpConnection;
import com.bugmaker.util.PrintUtil;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by kinthon on 17-6-25.
 */

@Controller("userAction")
@Scope("prototype")
public class UserAction extends ActionSupport {
    @Resource
    private UserService userService;

    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    //登录模块
    public void login() {
        //接口文档约束
        System.out.println("登录功能");
        Map<String, Object> map = new HashMap<String, Object>();                //map用来封装对象，在转换为json的时候不会出现格式错误
        boolean status = false;                                    //给前端判断的值

        //实例化request,respond
        HttpConnection connection = new HttpConnection();
        connection.getObject(ServletActionContext.getRequest(),
                ServletActionContext.getResponse());


//------------逻辑代码------------//
        //DEBUG:辅助输出,查看Spring是否成功注值
        PrintUtil.print(user);
        //尝试登陆
        if(userService.login(user)) {
            System.out.println("登录成功");
            //登陆成功，根据id查出用户的详细信息
            user = userService.getUserById(user.getAccountNumber());
            status = true;
        } else {
            status = false;
        }

        //DEBUG:辅助输出,输出登录查询到的用户信息
        PrintUtil.print(user);

        //接口文档约束
        EntityToJsonUtil.transfer(user,map);
        map.put("state", status);
//------------逻辑代码------------//

        //发送数据
        connection.sendObject(map);
    }

    //注册模块
    public void register() {
        //接口文档约束
        System.out.println("注册功能");
        Map<String, Object> map = new HashMap<String, Object>();
        boolean status = false;

        //实例化request,respond
        HttpConnection connection = new HttpConnection();
        connection.getObject(ServletActionContext.getRequest(),
                ServletActionContext.getResponse());
//------------逻辑代码------------//
        //初始化头像参数和信誉值
        user.setAvatar("123");
        user.setCredibility(100);
        //DEBUG:辅助输出
        PrintUtil.print(user);
        //尝试登陆
        if(userService.register(user)) {
            System.out.println("注册成功");
            //注册成功，根据id查出用户的详细信息
            user = userService.getUserById(user.getAccountNumber());
            status = true;
        } else {
            status = false;
        }

        //DEBUG:辅助输出
        PrintUtil.print(user);

        //接口文档约束
        map.put("status", status);
        map.put("registerAccount", user.getAccountNumber());
//------------逻辑代码------------//

        //发送数据
        connection.sendObject(map);
    }
    //修改密码模块
    public void changePassword() {
        System.out.println("修改密码功能");
        //接口文档约束
        Map<String, Object> map = new HashMap<String, Object>();
        boolean status = false;

        //获取输入流
        HttpConnection connection = new HttpConnection();
        connection.getObject(ServletActionContext.getRequest(),
                ServletActionContext.getResponse());

//------------逻辑代码------------//
        //DEBUG:辅助输出
        PrintUtil.print(user);
        //返回给前端判断是否成功修改密码的值
        status = userService.changePassword(user);

        //DEBUG:辅助输出
        PrintUtil.print(user);

        //接口文档约束
        //EntityToJsonUtil.transfer(user,map);
        map.put("state", status);
//------------逻辑代码------------//

        //发送数据
        connection.sendObject(map);
    }
}