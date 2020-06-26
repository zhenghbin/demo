package com.example.demo.concurrent;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * ExecutorTest 线程池
 *
 * @author zhbin
 * @date 2020-06-24
 */
@Configuration
public class ExecutorTest {
    private static final int max_size = 5;



    @Bean(name = "ExecutorT")
    public ExecutorService executor(){
        return Executors.newFixedThreadPool(max_size);
    }
}
