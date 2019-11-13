package com.bugmaker.service;

import com.bugmaker.entity.Orders;
import org.springframework.core.annotation.Order;

import java.util.List;

public interface OrderService {
    //增加订单
    public boolean addOrder(Orders orders);
    //查询订单表
    public List<Orders> getAllOrders(String status);

    public Orders getOrdersById(String id);

    public boolean updateOrders(Orders orders);

}
