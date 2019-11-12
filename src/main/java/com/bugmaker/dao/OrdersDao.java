package com.bugmaker.dao;

import com.bugmaker.entity.Orders;

import java.util.List;


/**
 * Created by kinthon on 17-6-23.
 */
public interface OrdersDao {

    /**
     * 添加并保存用户
     * @param order
     */
    public void add(Orders order);


//    /**
//     * 查询订单状态
//     * @param ordersStatus
//     */
//    public Orders seekStatus(String ordersStatus);

    /**
     * 根据用户id删除用户信息
     * @param AccountNumber
     */
    public void delete(String AccountNumber);

    /**
     * 根据主键更新用户信息
     * @param order
     */
    public void update(Orders order);


    /**
     * 获取用户列表
     */
    public List getOrders();

    /**
     * 根据用户orderNumber获取用户信息
     * @param orderNumber
     */
    public Orders getOrders(String orderNumber);


//    /**
//     * 根据账户和密码获取用户信息
//     * @param order
//     */
//    public boolean findOrders(Orders order);

}