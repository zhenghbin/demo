package com.example.demo.concurrent;

import com.alibaba.fastjson.JSONObject;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.rabbitmq.client.UnblockedCallback;
import lombok.SneakyThrows;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ForceTest
 *
 * @author zhbin
 * @date 2020-06-22
 */
@Configuration
public class ForceTest {

//    @Bean("executorService")
//    public ExecutorService executorService(){
//        return Executors.newFixedThreadPool(8);
//    }

    class SsTask extends RecursiveTask<Integer> {

        @Override
        protected Integer compute() {
            return 1;
        }
    }

    //    @SneakyThrows
    public static void test() {
        int i = 1 / 0;
    }

    volatile static Integer num = 0;

    public static void main(String[] args) throws InterruptedException {
//        Timer timer = new Timer();
//            test();

//        1.CompletableFuture
//        CompletableFuture<Void> future = CompletableFuture.runAsync(() -> System.out.println(1 / 0));
//        List<CompletableFuture<Void>> onLineQueryTaskList = new ArrayList<>();
//        onLineQueryTaskList.add(future);
//        System.out.println(CollectionUtils.isEmpty(onLineQueryTaskList));
//
//        CompletableFuture.allOf(onLineQueryTaskList.toArray(new CompletableFuture[0])).join();

        ExecutorService executorService = Executors.newFixedThreadPool(10);

        AtomicInteger atomicInteger = new AtomicInteger();

        ReentrantLock lock = new ReentrantLock();

        long start = System.currentTimeMillis();
        for (int i = 0; i < 20; i++) {
            Thread r = new Thread(() -> {
//                lock.lock();

                    for (int j = 0; j < 10000; j++) {
                        num++;
//                    num.getAndIncrement();
                }
//                lock.unlock();
//                atomicInteger.getAndIncrement();
            });
            r.start();
        }
        while (Thread.activeCount() > 1) {
            Thread.yield();
        }
        System.out.println(System.currentTimeMillis() - start);
        System.out.println(num);
//
//        CountDownLatch countDownLatch = new CountDownLatch(10);
//
//        Runnable runnable = () -> {
//            try {
//                for (int i = 0; i < 100; i++) {
//                    countDownLatch.countDown();
//                    num++;
//                }
//
//            }catch (Exception e) {
////                for (int i = 0; i < 10; i++) {
////                    countDownLatch.countDown();
////                }
//            }
//
//        };
//        runnable.run();
//        countDownLatch.await();
//        System.out.println(num);
//        System.out.println(1);
//        FutureTask futureTask = new FutureTask<Void>(runnable);
//        executorService.submit(futureTask);
//        executorService.shutdownNow();
//        ForkJoinPool forkJoinPool = new ForkJoinPool();
//        forkJoinPool.invoke(new SsTask())


//        HashMap<String, HashMap<String,String>> map = new HashMap<>();
//        HashMap<String, String> f = new HashMap<>();
//        f.put("2","44");
//        map.put("1",f);
//        HashMap<String, String> result = map.get("1");
//
//        f.put("2","b");
//        map.put("1", f);
//        System.out.println(JSONObject.toJSON(result));


//        Cache<String, String> cacheBuilder = CacheBuilder.newBuilder()
//                .initialCapacity(100)
//                .maximumSize(1000)
//                .expireAfterWrite(1, TimeUnit.HOURS)
//                .build();
//        cacheBuilder.put("1","a");
//        ConcurrentMap<String, String> map = cacheBuilder.asMap();
//        System.out.println(map.toString());
//        cacheBuilder.invalidate("1");
////        for (int i=0;i<map.size();i++){
////            map.put("1", "b");
////        }

//        System.out.println(cacheBuilder.size());

//        System.out.println("ddd".join(",","323"));
//        Timer timer = new Timer();
//        timer.schedule(new TimerTask() {
//
//            @Override
//            public void run() {
//                System.out.println(1);
//                timer.cancel();
//            }
//        },0, 1000);
//        ExecutorService executorService = Executors.newFixedThreadPool(8);
//        String task = "hour";
//        executorService.execute(()-> {
//            System.out.println(task);
//        });
//        task = "day";
//        executorService.execute(()-> {
//            System.out.println(task);
//        });
//        for (int i=0;i<10;i++) {
//            executorService.execute(()-> {
//                try {
//                    Thread.sleep(10000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                System.out.println(1);
//            });
//        }

//        for (int i=0;i<5;i++) {
//            Thread.sleep(1000);
//            System.out.println(1);
//            if (i==3) break;
////            timer.schedule(new TimerTask() {
////                @Override
////                public void run() {
////                    System.out.println(1);
////                }
////            },1000);
//        }
    }
}
