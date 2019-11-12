package com.bugmaker.util;

import com.bugmaker.entity.Order;
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
    public static void transferOrder(Order order, Map<String, Object> map){
        map.put("Title",order.getTitle());
        map.put("Time",order.getTime());
        map.put("Address",order.getAddress());
        map.put("Pnumber",order.getPnumber());
        map.put("Event",order.getEvent());
        map.put("Aging",order.getAging());
        map.put("Reward",order.getReward());
        map.put("Contact",order.getContact());
        map.put("Seeker",order.getSeeker());
        map.put("Helper",order.getHelper());
        map.put("OrderStatus",order.getOrderStatus());

    }
}
