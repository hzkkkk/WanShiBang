package com.bugmaker.service.impl;

import com.bugmaker.dao.OrdersDao;
import com.bugmaker.entity.Orders;
import com.bugmaker.service.OrdersService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


//注入服务
@Service("ordersService")
public class OrdersServiceImpl implements OrdersService {
    //自动注入ordersDao，也可以使用@Autowired
    @Resource
    private OrdersDao ordersDao;

    //-------自定义函数---------//

//    @Override
//    public boolean login(Orders orders) {
//        if(this.ordersDao.getOrders(orders.getAccountNumber()) != null) {
//            System.out.println("查询结果true");
//            return true;
//        }else{
//            System.out.println("查询结果false");
//            return false;
//        }
//    }


//    @Override
//    public boolean register(Orders orders) {
//        if(this.ordersDao.findOrders(orders)) {
//            System.out.println("用户已存在");
//            return false;
//        } else {
//            System.out.println("用户检验通过");
//
//            if (addOrders(orders)) {
//                System.out.println("注册成功");
//                return true;
//            }
//            else {
//                System.out.println("注册失败");
//                return false;
//            }
//        }
//    }

    //-------自定义函数---------//

    @Override
    public boolean addOrders(Orders orders) {
        this.ordersDao.add(orders);
        return true;
    }

//    @Override
//    public boolean seekStatus(String ordersStatus) {
//        this.ordersDao.seekStatus(ordersStatus);
//        return true;
//    }

    @Override
    public List getAllOrders() {
        return this.ordersDao.getOrders();
    }

    @Override
    public Orders getOrdersById(String id) {
        return this.ordersDao.getOrders(id);
    }

    @Override
    public boolean updateOrders(Orders orders) {
        this.ordersDao.update(orders);
        return true;

    }

    @Override
    public boolean deleteOrders(String id) {
        this.ordersDao.delete(id);
        return true;
    }
}