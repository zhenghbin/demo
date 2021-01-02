package com.example.demo.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.context.event.ContextStoppedEvent;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutorService;

@Service
public class Test2 implements ApplicationListener {

//    @Autowired
//    @Qualifier("executorService")
//    private ExecutorService executorService;

    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        if(event instanceof ContextRefreshedEvent) {
            System.out.println("容器刷新");
//            executorService.execute(()-> {
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                System.out.println(1);
//            });
        }
        if(event instanceof ContextStartedEvent) {
            System.out.println("容器启动");
        }
        if(event instanceof ContextStoppedEvent) {
            System.out.println("容器停止");
        }
        if(event instanceof ContextClosedEvent) {
            System.out.println("容器关闭");
//            executorService.shutdown();
//            while (!executorService.isTerminated()) {
//            }
            System.out.println("线程关闭");
        }
    }
}