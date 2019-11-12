package com.bugmaker.action;

import com.bugmaker.entity.Order;
import com.bugmaker.service.OrderService;
import com.bugmaker.util.EntityToJsonUtil;
import com.bugmaker.util.HttpConnection;
import com.bugmaker.util.PrintUtil;
import com.sun.org.apache.xpath.internal.operations.Or;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

@Controller("orderAction")
@Scope("prototype")
public class OrderAction {
    @Resource
    private OrderService orderService;
    private Order order;

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public void receive(){
        Map<String,Object> map=new HashMap<String,Object>();
        boolean status=false;
        HttpConnection connection=new HttpConnection();
        //实例化输入,输入流
        connection.getObject(ServletActionContext.getRequest(),ServletActionContext.getResponse());
        PrintUtil.printObject(order);
        if(orderService.addOrder(order)){
            status=true;
        }
        else {
            status=false;
        }
        EntityToJsonUtil.transferOrder(order,map);
        map.put("state",status);
        connection.sendObject(map);
    }


}
