//package com.example.demo.producer;
//
//import org.springframework.amqp.rabbit.core.RabbitTemplate;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
///**
// * @author zhbin
// * @date 2018/12/13.
// */
//@Service
//public class ProducerTest1 {
//
//    private final RabbitTemplate rabbitTemplate;
//
//    @Autowired
//    public ProducerTest1(RabbitTemplate rabbitTemplate) {
//        this.rabbitTemplate = rabbitTemplate;
//    }
//    public void producer(){
//        rabbitTemplate.convertAndSend("test","message");
//    }
//}
