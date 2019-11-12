package com.bugmaker.service;

import com.bugmaker.entity.Orders;

import java.util.List;

/**
 * Created by kinthon on 17-6-23.
 */
public interface OrdersService {
    //-------自定义函数---------//
//    public boolean login(Orders orders);
//
//    public boolean register(Orders orders);
//-------自定义函数---------//

    public boolean addOrders(Orders orders);

    //public boolean seekStatus(String ordersStatus);

    public List getAllOrders();

    public Orders getOrdersById(String id);

    public boolean updateOrders(Orders orders);

    public boolean deleteOrders(String id);
}