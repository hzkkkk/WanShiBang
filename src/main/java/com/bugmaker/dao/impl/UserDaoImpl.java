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

    //-------自定义函数---------//
    @Override
    public boolean login(User user) {
        Iterator<User> it;
        String hsql="from User u where u.accountNumber=? and u.password=?";
        System.out.println("sql:" + hsql);
        Query query = sessionFactory.getCurrentSession().createQuery(hsql);
        query.setString(0, user.getAccountNumber());
        query.setString(1, user.getPassword());
        System.out.println(user.getAccountNumber());
        System.out.println(user.getPassword());
        it=query.iterate();
        if(it.hasNext()) {
            System.out.println("查询结果true");
            return true;
        } else {
            System.out.println("查询结果false");
            return false;
        }
    }


    @Override
    public boolean register(User user) {
        Iterator<User> it;
        String hsql="from User u where u.accountNumber=?";
        System.out.println("sql:" + hsql);
        Query query = sessionFactory.getCurrentSession().createQuery(hsql);
        query.setString(0, user.getAccountNumber());
        it=query.iterate();
        if(it.hasNext()) {
            System.out.println("用户已存在");
            return false;
        } else {
            System.out.println("注册成功");
            add(user);
            return true;
        }
    }

    //-------自定义函数---------//




    @Override
    public void add(User user) {
        sessionFactory.getCurrentSession().save(user);
    }


    @Override
    public List getUser() {
        return sessionFactory.getCurrentSession().createQuery("FROM User").list();
    }

    @Override
    public User getUser(String id) {
        return (User)sessionFactory.getCurrentSession().get(User.class, id);
    }

    @Override
    public void update(User user) {
        sessionFactory.getCurrentSession().update(user);
    }

    @Override
    public void delete(String id) {
        sessionFactory.getCurrentSession().delete(
                sessionFactory.getCurrentSession().get(User.class, id)
        );
    }
}