package com.bugmaker.service.impl;

import com.bugmaker.dao.OrderDao;
import com.bugmaker.entity.Orders;
import com.bugmaker.service.OrderService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service("orderService")
//@Transactional(readOnly =false)
public class OrderServiceImpl implements OrderService {
    @Resource
    private OrderDao orderDao;
//    @Transactional(readOnly =false)
    public boolean addOrder(Orders orders){
        orderDao.add(orders);
        return true;
    }
    public List<Orders> getAllOrders(String status){
        return orderDao.getAllOrders(status);
    }
    public Orders getOrdersById(String id) {
        return this.orderDao.getOrders(id);
    }

    public boolean updateOrders(Orders orders) {
        this.orderDao.update(orders);
        return true;

    }
}
