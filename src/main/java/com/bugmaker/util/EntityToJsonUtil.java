package com.bugmaker.util;

import com.bugmaker.entity.Orders;
import com.bugmaker.entity.User;

import java.util.Map;


public class EntityToJsonUtil {
    public static void transfer(User user, Map<String, Object> map){
        map.put("account_Number",user.getAccountNumber());
        map.put("password",user.getPassword());
        map.put("name",user.getName());
        map.put("avatar",user.getAvatar());
        map.put("credibility",user.getCredibility());
    }

    public static void transfer(Orders orders, Map<String, Object> map){
        map.put("Title",orders.getTitle());
        map.put("Time",orders.getTime("String"));
        map.put("Address",orders.getAddress());
        map.put("Pnumber",orders.getPnumber());
        map.put("Event",orders.getEvent());
        map.put("Aging",orders.getAging("String"));
        map.put("Reward",orders.getReward());
        map.put("Contact",orders.getContact());
        map.put("Seeker",orders.getSeeker());
        map.put("Helper",orders.getHelper());
        map.put("OrdersStatus",orders.getOrderStatus());
        map.put("OrdersNumber",orders.getOrderNumber());
    }

}
