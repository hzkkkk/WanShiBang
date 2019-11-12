package com.bugmaker.service.impl;

import com.bugmaker.dao.UserDao;
import com.bugmaker.entity.User;
import com.bugmaker.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


//注入服务
@Service("userService")
public class UserServiceImpl implements UserService{
    //自动注入userDao，也可以使用@Autowired
    @Resource
    private UserDao userDao;

    //-------自定义函数---------//

    @Override
    public boolean login(User user) {
        if(this.userDao.getUser(user.getAccountNumber()) != null) {
            System.out.println("查询结果true");
            return true;
        }else{
            System.out.println("查询结果false");
            return false;
        }
    }


    @Override
    public boolean register(User user) {
        if(this.userDao.findUser(user)) {
            System.out.println("用户已存在");
            return false;
        } else {
            System.out.println("用户检验通过");

            if (addUser(user)) {
                System.out.println("注册成功");
                return true;
            }
            else {
                System.out.println("注册失败");
                return false;
            }
        }
    }


    @Override
    public boolean changePassword(User user) {
        return this.userDao.changePassword(user);
    }

    //-------自定义函数---------//

    @Override
    public boolean addUser(User user) {
        this.userDao.add(user);
        return true;
    }

    @Override
    public List getAllUser() {
        return this.userDao.getUser();
    }

    @Override
    public User getUserById(String id) {
        return this.userDao.getUser(id);
    }

    @Override
    public boolean updateUser(User user) {
        this.userDao.update(user);
        return true;

    }

    @Override
    public boolean deleteUser(String id) {
        this.userDao.delete(id);
        return true;
    }
}