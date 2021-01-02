package com.example.demo.google;

import com.google.common.cache.*;
import com.google.common.util.concurrent.ListenableFuture;
import lombok.NonNull;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.TimeUnit;

public class Test1 {
//    private static RemovalListener<String,String> removalListener = notification -> {
//        System.out.println(notification.getKey());
//        System.out.println(notification.getValue());
//        System.out.println(notification.getCause());
//    };

    public static void main(String[]args){
        ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<String, Integer>();

        Integer integer = map.put("1123", 123);
        map.remove(1123);
        System.out.println(map.size());
//        Integer count = 1;
//        count -= 2;
//        System.out.println(count);

//        RemovalListener<String,Integer> removalListener = new RemovalListener<String,Integer>() {
//            @Override
//            public void onRemoval(RemovalNotification<String,Integer> notification) {
//
//                System.out.println(notification.getKey());
//                System.out.println(notification.getValue());
//                System.out.println(notification.getCause());
//                notification.setValue(notification.getValue() - 1);
//            }
//        };
//        Cache<String, Integer> cache = CacheBuilder.newBuilder()
//                .initialCapacity(100)
//                .maximumSize(1000)
//                .build();
//        cache.put("1",6);
//        System.out.println(cache.size());
////        cache.invalidate("1");
////        System.out.println(cache.size());
//        ConcurrentMap<String, Integer> map = cache.asMap();
//        for (Map.Entry entry : map.entrySet()) {
//            System.out.println(entry.getKey());
//            System.out.println(entry.getValue());
//        }
//        System.out.println(cache.stats());
//        cache.invalidate("1");
//        cache.invalidate("1");
//        cache.invalidate();

//        for(int i=0;i<20;i++)
//        {
//            System.out.println(us.getUserName("1001"));
//            TimeUnit.SECONDS.sleep(1);
//        }


//        try {
//            Thread.sleep(5000);
//            System.out.println(cache.getIfPresent("1"));
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }



    }
}
