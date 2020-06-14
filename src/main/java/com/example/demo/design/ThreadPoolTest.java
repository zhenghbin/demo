package com.example.demo.design;

import lombok.Data;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.concurrent.*;

/**
 * ThreadPoolTest
 *
 * @author zhbin
 * @date 2020-06-07
 */
@Slf4j
@Data
public class ThreadPoolTest  {
    static CyclicBarrier cyclicBarrier = new CyclicBarrier(10);

    public static void main (String[] args ) throws InterruptedException {
//        byte a = 0;
////        a = a +1;
//
//
//        a+=1;
//        System.out.println(a);
        anonation();
//
//        ExecutorService executorService = Executors.newFixedThreadPool(50);
//        for (int i=0;i<10;i++){
//            try {
//                Thread.sleep(100);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            executorService.submit(new Thread(() -> {
//                try {
//                    cyclicBarrier.wait();
//                    increment();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }));
//        }
//        executorService.shutdown();
//        while (!executorService.awaitTermination(1, TimeUnit.SECONDS)) {
//            System.out.println("线程还在执行。。。");
//        }
//        System.out.println(i);
    }
    public static void anonation() {
        System.out.println(Arrays.toString(ThreadPoolTest.class.getDeclaredFields()));
        System.out.println(ThreadPoolTest.class.getAnnotation(Data.class));
        System.out.println(Arrays.toString(ThreadPoolTest.class.getDeclaredClasses()));
        System.out.println(Arrays.toString(ThreadPoolTest.class.getDeclaredMethods()));
    }

    @Data
    class inner {
         int i = 0;

          void increment(){
            ++i;
        }
    }



}
