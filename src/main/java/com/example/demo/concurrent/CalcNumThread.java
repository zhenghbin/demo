package com.example.demo.concurrent;

import lombok.Getter;
import org.springframework.stereotype.Component;

import java.util.concurrent.CountDownLatch;

/**
 * CalcNumThread
 *
 * @author zhbin
 * @date 2020-06-24
 */
@Component
public class CalcNumThread implements Runnable{

        @Getter
        private int i = 0;


        /**
         * 去掉synchronized关键词同步锁，会导致i变量出现线程不安全，计数错误
         */
        @Override
        public synchronized void run() {
//
//                cdl.countDown();//递减1
//
//                try {
//                        cdl.await();//等待
//                } catch (InterruptedException e) {
//                        e.printStackTrace();
//                }
                        i ++;

        }
}
