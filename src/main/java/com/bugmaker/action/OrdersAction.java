package com.bugmaker.action;

import com.bugmaker.config.Configure;
import com.bugmaker.entity.Orders;
import com.bugmaker.service.OrdersService;
import com.bugmaker.util.DataToString;
import com.bugmaker.util.EntityToJsonUtil;
import com.bugmaker.util.HttpConnection;
import com.bugmaker.util.PrintUtil;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller("ordersAction")
@Scope("prototype")
public class OrdersAction extends ActionSupport {
    @Resource
    private OrdersService ordersService;

    private Orders orders;

    public Orders getOrders() {
        return orders;
    }

    public void setOrders(Orders orders) {
        this.orders = orders;
    }

    public void receive(){
        Map<String,Object> map=new HashMap<String,Object>();
        boolean status=false;
        HttpConnection connection=new HttpConnection();
        //实例化输入,输入流
        connection.getObject(ServletActionContext.getRequest(),ServletActionContext.getResponse());


        //根据日期转换为主键OrdersNumber
        Date current_date = new Date(); //获取系统时间
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String current_date_str = sdf.format(current_date);
        String data_str = DataToString.transfer(current_date_str);
        orders.setOrderNumber(data_str);

        //初始化orders_status为wait
        orders.setOrderStatus(Configure.orders_status.WAIT.toString());


        //DEBUG:辅助输出
        PrintUtil.print(orders);

        if(ordersService.addOrders(orders)){
            status=true;
        }
        else {
            status=false;
        }
        EntityToJsonUtil.transfer(orders,map);
        map.put("state",status);
        connection.sendObject(map);
    }

    public void seekOrderStatus(){
        Map<String,Object> map=new HashMap<String,Object>();
        boolean status=false;
        HttpConnection connection=new HttpConnection();
        //实例化输入,输入流
        connection.getObject(ServletActionContext.getRequest(),ServletActionContext.getResponse());

        //获取订单状态的详细值
        Orders searchOrder = ordersService.getOrdersById(orders.getOrderNumber());

        //查询订单状态
        String nowStatus = searchOrder.getOrderStatus();

        //DEBUG:辅助输出
        PrintUtil.print(orders);

        if(nowStatus.length() != 0){
            status = true;
        }
        else {
            status = false;
        }

        //DEBUG:辅助输出
        PrintUtil.print(orders);

        EntityToJsonUtil.transfer(orders,map);
        map.put("state",status);
        connection.sendObject(map);
    }

    public void cancelOrders(){
        Map<String,Object> map=new HashMap<String,Object>();
        boolean state=false;
        HttpConnection connection=new HttpConnection();
        //实例化输入,输入流
        connection.getObject(ServletActionContext.getRequest(),ServletActionContext.getResponse());

        //获取订单状态的详细值
        Orders orders_search = ordersService.getOrdersById(orders.getOrderNumber());
        //更改订单状态
        orders_search.setOrderStatus(Configure.orders_status.CANCEL.toString());

        //DEBUG:辅助输出
        PrintUtil.print(orders_search);

        if(ordersService.updateOrders(orders_search)){
            state=true;
        }
        else {
            state=false;
        }
        map.put("state",state);
        connection.sendObject(map);
    }


}
