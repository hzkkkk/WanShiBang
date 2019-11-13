package com.bugmaker.dao.impl;

import com.bugmaker.dao.OrderDao;
import com.bugmaker.entity.Orders;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.awt.*;
import java.util.List;

//这个类里面的方法出现Exception异常回滚
@Transactional(rollbackFor = Exception.class)

@Repository("orderDao") //进行注入
public class OrderDaoImpl implements OrderDao {
    @Resource(name="sessionFactory")
    private SessionFactory sessionFactory;

    public void add(Orders orders){
        sessionFactory.getCurrentSession().save(orders);
        sessionFactory.getCurrentSession().flush();
    }


    @Override
    public List<Orders> getAllOrders(String orderStatus) {
//        return sessionFactory.getCurrentSession().createQuery("from Orders ").list();
        String hsql="from Orders o where o.orderStatus=?";
        Query query=sessionFactory.getCurrentSession().createQuery(hsql);
        query.setString(0,orderStatus);
        return query.list();
    }

    public Orders getOrders(String orderNumber) {
        return (Orders)sessionFactory.getCurrentSession().get(Orders.class, orderNumber);
    }

    public void update(Orders orders) {
        sessionFactory.getCurrentSession().update(orders);
    }
}

