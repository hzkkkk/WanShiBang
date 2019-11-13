package com.bugmaker.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataToString {
    public static String transfer(String str) {
        String regEx="[^0-9]";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(str);
        return (m.replaceAll("").trim());
    }
}
//
// str = str.trim();
//         String new_str = "";
//         if (str != null && !"".equals(str)) {
//         for (int i = 0; i < str.length(); i++) {
//        if (str.charAt(i) >= 48 && str.charAt(i) <= 57) {
//        new_str += str.charAt(i);
//        }
//        }
//        }
//        return new_str;

//DEBUG:根据日期转换为主键OrdersNumber
//        String data_str = orders.getTime("String");
//        System.out.println("DEBUG:::data_str:"+ data_str);
//        data_str.replace("-","");
//        data_str.replace(":","");
//        data_str.replace(" ","");
//        System.out.println("DEBUG:::data_str:"+ data_str);