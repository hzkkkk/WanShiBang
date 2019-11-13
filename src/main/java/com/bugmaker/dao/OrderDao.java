package com.bugmaker.dao;

import com.bugmaker.entity.Orders;

import java.util.List;


public interface OrderDao {
    //插入订单
    public void add(Orders orders);
    //查询订单
    public List<Orders> getAllOrders(String status);

    public Orders getOrders(String orderNumber);

    public void update(Orders order);
}
