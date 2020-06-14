//package com.example.demo.consumer;
//
//import org.springframework.amqp.rabbit.annotation.RabbitHandler;
//import org.springframework.amqp.rabbit.annotation.RabbitListener;
//import org.springframework.stereotype.Service;
//
///**
// * @author zhbin
// * @date 2018/12/13.
// */
//@Service
//@RabbitListener(queues = "test")
//public class ConsumerTest1 {
//
//    @RabbitHandler
//    public void consumer(String message){
//        System.out.println(message);
//    }
//}
