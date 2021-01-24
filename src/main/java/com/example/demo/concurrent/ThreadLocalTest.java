package com.example.demo.concurrent;

//import com.rabbitmq.client.UnblockedCallback;

public class ThreadLocalTest {
    public static void main(String[]args) {
        int i=10;
        while (i-- > 0) {
            Runnable callback = () -> {
                ThreadLocal<Integer> threadLocal = new ThreadLocal<>();
                threadLocal.set(10);

                System.out.println(Thread.currentThread().getId() + "-" + threadLocal.get());
            };
            callback.run();
        }


    }
}
