package com.bugmaker.action;

import com.bugmaker.config.Configure;
import com.bugmaker.entity.Orders;
import com.bugmaker.service.OrderService;
import com.bugmaker.util.*;
import com.opensymphony.xwork2.ActionSupport;
import com.sun.org.apache.xpath.internal.operations.Or;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller("ordersAction")
@Scope("prototype")
public class OrdersAction extends ActionSupport{

    @Resource
    private OrderService orderService;
    private Orders orders;

    public Orders getOrders() {
        return orders;
    }

    public void setOrders(Orders orders) {
        this.orders = orders;
    }
    //插入订单模块
    public void receive(){
        System.out.println("接订单功能");
        Map<String,Object> map=new HashMap<String,Object>();                                   //map用来封装对象，在转换为json的时候不会出现格式错误
        boolean status=false;                                                      //给前端判断的值
        HttpConnection connection=new HttpConnection();
        //实例化request,respond
        connection.getObject(ServletActionContext.getRequest(),ServletActionContext.getResponse());

        //根据日期转换为主键OrdersNumber
        Date current_date = new Date(); //获取系统时间
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String current_date_str = sdf.format(current_date);
        String data_str = DataToString.transfer(current_date_str);                  //将--和空格去除

        //插入数据库操作，主键不能为空,且每次都不能重复。
        //初始化订单编号和订单状态
        orders.setOrderNumber(data_str);
        //初始化orders_status为wait
        orders.setOrderStatus(Configure.orders_status.WAIT.toString());
        PrintUtil.printObject(orders);
        //插入订单
        if(orderService.addOrder(orders)){
            status=true;
        }
        else {
            status=false;
        }
        //将order装入map
        EntityToJsonUtil.transferOrder(orders,map);
        map.put("state",status);
        connection.sendObject(map);
    }
    //显示帮助订单列表模块
    public void check(){
        System.out.println("查询所有订单功能");
        Map<String,Object> map=new HashMap<String,Object>();
        JSONArray jsonArray=new JSONArray();                        //前端接受的是JSONArray格式的数据
        //获取系统时间，用于判断订单是否过期
        Date current_date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String current_date_str = sdf.format(current_date);
        String data_str = DataToString.transfer(current_date_str);                  //将--和空格去除
        long now_time=Long.parseLong(data_str);                                     //由于时间数值较大，因此转为long型
        System.out.println("系统当前时间为"+now_time);
        //实例化request,respond
        HttpConnection connection=new HttpConnection();
        connection.getObject(ServletActionContext.getRequest(),ServletActionContext.getResponse());
        //前端请求的订单数state，first请求50条，add再请求30条
        String state=ServletActionContext.getRequest().getParameter("state");

        //前端发送过来下一次请求订单数的位置
        String startnumber=ServletActionContext.getRequest().getParameter("startnumber");
        System.out.println("要求增加的记录数:"+state);
        List<Orders> list=orderService.getAllOrders(Configure.orders_status.WAIT.toString());              //查询获得所有的订单
        System.out.println("Wait状态的记录数有"+list.size());
        //请求WAIT状态下的订单数
        if(state.equals("first")) {
            for (int i=0;i<list.size();i++) {
                //只发系统时间小于时效时间，即未过期的订单给前端
                if(now_time<Long.parseLong(DataToString.transfer(list.get(i).getAging("true")))) {
                    System.out.println(list.get(i));
                    EntityToJsonUtil.transferOrder(list.get(i), map);
                    JSONObject jsonObject = JsonUtil.createJsonObject(map);
                    JsonUtil.createJsonArray(jsonArray, jsonObject);
                }
            }
            connection.sendArrayObejct(jsonArray);
        }
        //再原来基础上再请求30条
        else if(state.equals("add")){
            int k=Integer.parseInt(startnumber);
            System.out.println(k);
            for (int i=0;i<3;i++){
                System.out.println(list.get(k));
                EntityToJsonUtil.transferOrder(list.get(k),map);
                JSONObject jsonObject = JsonUtil.createJsonObject(map);
                JsonUtil.createJsonArray(jsonArray,jsonObject);
                k++;
            }
            connection.sendArrayObejct(jsonArray);
        }

    }
    //查询订单状态模块
    public void seekOrderStatus(){
        System.out.println("查询订单状态功能");
        Map<String,Object> map=new HashMap<String,Object>();
        boolean status=false;
        HttpConnection connection=new HttpConnection();
        //实例化输入,输入流
        connection.getObject(ServletActionContext.getRequest(),ServletActionContext.getResponse());

        //------------逻辑代码------------//
        //DEBUG:辅助输出,接受前端发送的订单编号
        PrintUtil.printObject(orders);

        //根据订单编号获取订单的详细值
        Orders searchOrder = orderService.getOrdersById(orders.getOrderNumber());

        //查询订单状态
        String nowStatus = searchOrder.getOrderStatus();

        //DEBUG:辅助输出
        PrintUtil.printObject(orders);

        if(nowStatus.length() != 0){
            status = true;
        }
        else {
            status = false;
        }

        //DEBUG:辅助输出
        PrintUtil.printObject(orders);

//------------逻辑代码------------//
        EntityToJsonUtil.transferOrder(searchOrder,map);
        map.put("state",status);
        connection.sendObject(map);
    }

    //取消订单模块
    public void cancelOrders(){
        System.out.println("修改订单-取消订单功能");
        Map<String,Object> map=new HashMap<String,Object>();
        boolean state=false;
        HttpConnection connection=new HttpConnection();
        //实例化输入,输入流
        connection.getObject(ServletActionContext.getRequest(),ServletActionContext.getResponse());

        //获取订单的详细值
        Orders orders_search=orderService.getOrdersById(orders.getOrderNumber());
        //更改订单状态
        orders_search.setOrderStatus(Configure.orders_status.CANCEL.toString());

        //DEBUG:辅助输出
        PrintUtil.printObject(orders_search);
        //更新订单状态
        if(orderService.updateOrders(orders_search)){
            state=true;
        }
        else {
            state=false;
        }
        map.put("state",state);
        connection.sendObject(map);
    }
    //完成订单模块
    public void finished(){
        System.out.println("修改订单-完成订单功能");
        Map<String,Object> map=new HashMap<String,Object>();
        boolean state=false;
        HttpConnection connection=new HttpConnection();
        //实例化输入,输入流
        connection.getObject(ServletActionContext.getRequest(),ServletActionContext.getResponse());

        //获取订单的详细值
        Orders orders_search = orderService.getOrdersById(orders.getOrderNumber());

        //更改订单状态
        orders_search.setOrderStatus(Configure.orders_status.FINISH.toString());

        //DEBUG:辅助输出
        PrintUtil.printObject(orders_search);

        //更新订单状态
        if(orderService.updateOrders(orders_search)){
            state=true;
        }
        else {
            state=false;
        }

        map.put("OrderStatus",orders_search.getOrderStatus());
        map.put("state",state);
        connection.sendObject(map);
    }


}
