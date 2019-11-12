package com.bugmaker.util;


import com.bugmaker.entity.Orders;

public class EntityToEntityUtil {
    public static void  duplicate(Orders orders1, Orders orders2, String except) {
        if(orders1 != null){
            if(except.equals("OrderStatus"))
            {
                orders2.setTitle(orders1.getTitle());
                orders2.setTime(orders1.getTime());
                orders2.setAddress(orders1.getAddress());
                orders2.setPnumber(orders1.getPnumber());
                orders2.setEvent(orders1.getEvent());
                orders2.setAging(orders1.getAging());
                orders2.setReward(orders1.getReward());
                orders2.setContact(orders1.getContact());
                orders2.setSeeker(orders1.getSeeker());
                orders2.setHelper(orders1.getHelper());
                orders2.setOrderNumber(orders1.getOrderNumber());
            }
            else{
                System.out.println("EntityToEntityUtil.duplicate(Orders orders1, Orders orders2, String except):  " +
                        "issue not found, please contact with HZK");
            }
        }else{
            System.out.println("EntityToEntityUtil.duplicate(Orders orders1, Orders orders2, String except): " +
                    " orders1 is null");
        }


    }
}
