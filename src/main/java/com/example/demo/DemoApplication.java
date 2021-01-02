package com.example.demo;

import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class DemoApplication {

    @Bean
    public ExitCodeGenerator exitCodeGenerator() {
        System.out.println("退出");
        return () -> 42;
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}

