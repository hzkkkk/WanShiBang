package com.bugmaker.service;

import com.bugmaker.entity.User;

import java.util.List;

/**
 * Created by kinthon on 17-6-23.
 */
public interface UserService {
    //-------自定义函数---------//
    public boolean login(User user);

    public boolean register(User user);
//-------自定义函数---------//

    public boolean addUser(User user);

    public List getAllUser();

    public User getUserById(String id);

    public boolean updateUser(User user);

    public boolean deleteUser(String id);
}