package com.bugmaker.service.impl;

import com.bugmaker.dao.OrderDao;
import com.bugmaker.entity.Order;
import com.bugmaker.service.OrderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("orderService")
public class OrderServiceImpl implements OrderService {
    @Resource
    private OrderDao orderDao;
    public boolean addOrder(Order order){
        orderDao.add(order);
        return true;
    }

}
