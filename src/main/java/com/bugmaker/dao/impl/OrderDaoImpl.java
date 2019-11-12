package com.bugmaker.dao.impl;

import com.bugmaker.dao.OrderDao;
import com.bugmaker.entity.Order;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository("orderDao") //进行注入
public class OrderDaoImpl implements OrderDao {
    @Resource(name="sessionFactory")
    private SessionFactory sessionFactory;
    public void add(Order order){
        sessionFactory.getCurrentSession().save(order);
    }
}
