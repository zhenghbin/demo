package com.example.demo.google;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

import java.util.concurrent.TimeUnit;

public class Test1 {
    public static void main(String[]args){
        Cache<String, String> cache = CacheBuilder.newBuilder()
                .initialCapacity(100)
                .maximumSize(1000)
                .expireAfterWrite(1, TimeUnit.SECONDS)
                .build();
        cache.put("1","2");
        try {
            Thread.sleep(1000);
            System.out.println(cache.getIfPresent("1"));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }



    }
}
