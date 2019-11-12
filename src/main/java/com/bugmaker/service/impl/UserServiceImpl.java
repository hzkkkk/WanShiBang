package com.bugmaker.service.impl;

import com.bugmaker.dao.UserDao;
import com.bugmaker.entity.User;
import com.bugmaker.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by kinthon on 17-6-23.
 */
//注入服务
@Service("userService")
public class UserServiceImpl implements UserService{
    //自动注入userDao，也可以使用@Autowired
    @Resource
    private UserDao userDao;

    //-------自定义函数---------//

    @Override
    public boolean login(User user) {
        return this.userDao.login(user);
    }


    @Override
    public boolean register(User user) {
        return this.userDao.register(user);
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