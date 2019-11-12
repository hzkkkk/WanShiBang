package com.bugmaker.action;

import com.bugmaker.service.UserService;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import javax.annotation.Resource;
import com.bugmaker.entity.User;
import com.bugmaker.util.HttpConnection;



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

    public void login() {
        HttpConnection connection = new HttpConnection();
        String inputObject = connection.getObject(ServletActionContext.getRequest(),
                ServletActionContext.getResponse());

/////////
        if (userService.login(user)) {
        } else {

        }
        //////////////
        connection.sendObject(user);
    }

}