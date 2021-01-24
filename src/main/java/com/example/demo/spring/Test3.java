package com.example.demo.spring;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test3 {
    public static void main(String[]args) throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss") ;
//        System.out.println(date);
        String s = "Wed Jan 20 14:29:35 CST 2021";
        String date1 = sdf.format(new Date());
        System.out.println(date1);
    }
}
