package com.bugmaker.dao.impl;

import com.bugmaker.dao.OrdersDao;
import com.bugmaker.entity.Orders;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;


//这个类里面的方法出现Exception异常回滚
@Transactional(rollbackFor = Exception.class)

@Repository("ordersDao") //进行注入
public class OrdersDaoImpl implements OrdersDao {
    @Resource(name="sessionFactory")
    private SessionFactory sessionFactory;

    //-------增---------//
    //------------增加一个---------//
    @Override
    public void add(Orders orders) {
        sessionFactory.getCurrentSession().save(orders);
    }

    //-------删---------//
    //------------用主键删---------//
    @Override
    public void delete(String accountNumber) {
        sessionFactory.getCurrentSession().delete(
                sessionFactory.getCurrentSession().get(Orders.class, accountNumber)
        );
    }

    //-------改---------//
    //------------用主键改---------//
    @Override
    public void update(Orders orders) {
        sessionFactory.getCurrentSession().update(orders);
    }

    //-------查---------//
    //------------查整个表---------//
    @Override
    public List getOrders() {
        return sessionFactory.getCurrentSession().createQuery("FROM Orders").list();
    }

    //------------用主键查单个---------//
    @Override
    public Orders getOrders(String accountNumber) {
        return (Orders)sessionFactory.getCurrentSession().get(Orders.class, accountNumber);
    }


    //-------自定义函数---------//
    //------------用张查单个---------//
//    @Override
//    public boolean findOrders(Orders orders) {
//        Iterator<Orders> it;
//        String hsql="FROM Orders u where u.accountNumber=? and u.password=?";
//        System.out.println(hsql);
//        Query query = sessionFactory.getCurrentSession().createQuery(hsql);
//        query.setString(0, orders.());
//        query.setString(1, orders.getPassword());
//        System.out.println(orders.getAccountNumber());
//        it=query.iterate();
//        if(it.hasNext()) {
//            return true;
//        } else {
//            return false;
//        }
//    }

    //-------自定义函数---------//


}