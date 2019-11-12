package com.bugmaker.util;

import com.bugmaker.entity.Orders;
import com.bugmaker.entity.User;

public class PrintUtil {
    public static void print(User user){
        if(user != null){
            System.out.println("AccountNumber:"+user.getAccountNumber());
            System.out.println("Password:"+user.getPassword());
            System.out.println("Name:"+user.getName());
            System.out.println("Avatar:"+user.getAvatar());
            System.out.println("Credibility:"+user.getCredibility());
        }else{
            System.out.println("PrintUtil.print(user):  user is null");
        }

    }

    public static void print(Orders orders){
        if(orders != null){
            System.out.println("OrderNumber:"+orders.getOrderNumber());
            System.out.println("Title:"+orders.getTitle());
            System.out.println("Time:"+orders.getTime());
            System.out.println("Address:"+orders.getAddress());
            System.out.println("Pnumber:"+orders.getPnumber());
            System.out.println("Event:"+orders.getEvent());
            System.out.println("Reward:"+orders.getReward());
            System.out.println("Aging:"+orders.getAging());
            System.out.println("Contact:"+orders.getContact());
            System.out.println("Seeker:"+orders.getSeeker());
            System.out.println("Helper:"+orders.getHelper());
            System.out.println("OrderStatus:"+orders.getOrderStatus());
        }else{
            System.out.println("PrintUtil.print(user):  user is null");
        }

    }

}
