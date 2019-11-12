package com.bugmaker.dao;

import com.bugmaker.entity.User;

import java.util.List;

/**
 * Created by kinthon on 17-6-23.
 */
public interface UserDao {

    /**
     * 添加并保存用户
     * @param user
     */
    public void add(User user);


    /**
     * 根据用户id删除用户信息
     * @param AccountNumber
     */
    public void delete(String AccountNumber);

    /**
     * 根据主键更新用户信息
     * @param user
     */
    public void update(User user);


    /**
     * 获取用户列表
     */
    public List getUser();

    /**
     * 根据用户AccountNumber获取用户信息
     * @param AccountNumber
     */
    public User getUser(String AccountNumber);


    /**
     * 根据账户和密码获取用户信息
     * @param user
     */
    public boolean findUser(User user);


    /**
     * 修改密码
     */
    public boolean changePassword(User user);
}