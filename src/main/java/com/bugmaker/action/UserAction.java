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

    public void  login() {
        //接口文档约束
        Map<String, Object> map = new HashMap<String, Object>();
        boolean state = false;

        //获取输入流
        HttpConnection connection = new HttpConnection();
        connection.getObject(ServletActionContext.getRequest(),
                ServletActionContext.getResponse());

//------------逻辑代码------------//
        //DEBUG:辅助输出
        PrintUtil.print(user);
        //尝试登陆
        if(userService.login(user)) {
            //登陆成功，根据id查出用户的详细信息
            user = userService.getUserById(user.getAccountNumber());
            state = true;
        } else {
            state = false;
        }

        //DEBUG:辅助输出
        PrintUtil.print(user);

        //接口文档约束
        EntityToJsonUtil.transfer(user,map);
        map.put("state", state);
//------------逻辑代码------------//

        //发送数据
        connection.sendObject(map);
    }


    public void register() {
        //接口文档约束
        Map<String, Object> map = new HashMap<String, Object>();
        boolean state = false;

        //获取输入流
        HttpConnection connection = new HttpConnection();
        connection.getObject(ServletActionContext.getRequest(),
                ServletActionContext.getResponse());

//------------逻辑代码------------//
        //DEBUG:辅助输出
        PrintUtil.print(user);
        //尝试登陆
        if(userService.register(user)) {
            //登陆成功，根据id查出用户的详细信息
            user = userService.getUserById(user.getAccountNumber());
            state = true;
        } else {
            state = false;
        }

        //DEBUG:辅助输出
        PrintUtil.print(user);

        //接口文档约束
        map.put("state", state);
        map.put("registerAccount", user.getAccountNumber());
//------------逻辑代码------------//

        //发送数据
        connection.sendObject(map);
    }

    public void changePassword() {
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


        //尝试更改密码,确保为登录状态
        if(userService.login(user)) {
            user = userService.getUserById(user.getAccountNumber());

            status =  userService.changePassword(user);
        } else {
            status = false;
        }

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