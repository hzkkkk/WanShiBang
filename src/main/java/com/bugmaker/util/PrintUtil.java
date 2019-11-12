package com.bugmaker.util;

import com.bugmaker.entity.User;

public class PrintUtil {
    public static void print(User user){
        System.out.println("AccountNumber:"+user.getAccountNumber());
        System.out.println("Password:"+user.getPassword());
        System.out.println("Name:"+user.getName());
        System.out.println("Avatar:"+user.getAvatar());
        System.out.println("Credibility:"+user.getCredibility());
    }
    public static void printObject(Object object){
        System.out.println(object);
    }
}
