package com.bugmaker.dao;

import com.bugmaker.entity.User;

import java.util.List;

/**
 * Created by kinthon on 17-6-23.
 */
public interface UserDao {
    //-------自定义函数---------//
    /**
     * 登录
     */
    public boolean login(User user);

    /**
     * 注册
     */
    public boolean register(User user);

    //-------自定义函数---------//



    /**
     * 添加并保存用户
     * @param user
     */
    public void add(User user);




    /**
     * 获取用户列表
     */
    public List getUser();

    /**
     * 根据用户Id获取用户信息
     * @param id
     * @return
     */
    public User getUser(String id);

    /**
     * 更新用户信息
     * @param user
     */
    public void update(User user);


    /**
     * 根据用户id删除用户信息
     * @param id
     */
    public void delete(String id);

}