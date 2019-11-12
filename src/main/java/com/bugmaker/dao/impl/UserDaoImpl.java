package com.bugmaker.dao.impl;

import com.bugmaker.dao.UserDao;
import com.bugmaker.entity.User;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Iterator;
import java.util.List;

/**
 * Created by kinthon on 17-6-23.
 */


//这个类里面的方法出现Exception异常回滚
@Transactional(rollbackFor = Exception.class)

@Repository("userDao") //进行注入
public class UserDaoImpl implements UserDao {
    @Resource(name="sessionFactory")
    private SessionFactory sessionFactory;




    //-------增---------//
    //------------增加一个---------//
    @Override
    public void add(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    //-------删---------//
    //------------用主键删---------//
    @Override
    public void delete(String accountNumber) {
        sessionFactory.getCurrentSession().delete(
                sessionFactory.getCurrentSession().get(User.class, accountNumber)
        );
    }

    //-------改---------//
    //------------用主键改---------//
    @Override
    public void update(User user) {
        sessionFactory.getCurrentSession().update(user);
    }

    //-------查---------//
    //------------查整个表---------//
    @Override
    public List getUser() {
        return sessionFactory.getCurrentSession().createQuery("FROM User").list();
    }

    //------------用主键查单个---------//
    @Override
    public User getUser(String accountNumber) {
        return (User)sessionFactory.getCurrentSession().get(User.class, accountNumber);
    }


    //-------自定义函数---------//
    //------------用张查单个---------//
    @Override
    public boolean findUser(User user) {
        Iterator<User> it;
        String hsql="FROM User u where u.accountNumber=? and u.password=?";
        System.out.println(hsql);
        Query query = sessionFactory.getCurrentSession().createQuery(hsql);
        query.setString(0, user.getAccountNumber());
        query.setString(1, user.getPassword());
        System.out.println(user.getAccountNumber());
        it=query.iterate();
        if(it.hasNext()) {
            return true;
        } else {
            return false;
        }
    }

    //-------自定义函数---------//


}