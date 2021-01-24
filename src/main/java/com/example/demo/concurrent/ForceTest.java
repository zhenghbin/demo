package com.example.demo.concurrent;

import org.springframework.context.annotation.Configuration;

import java.util.*;
import java.util.concurrent.*;

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
//        timer.schedule(new TimerTask() {
//            @Override
//            public void run() {
//                try {
//                    int i = 1/0;
//                    System.out.println(1);
//                }catch (Exception e) {
//                    System.out.println(2);
//                    e.getMessage();
//                }
//            }
//        }, 5, 1000);

        ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(3);
        RunnableFuture<Integer> runnableFuture = new RunnableFuture<Integer>() {
            int i = 10;

            @Override
            public boolean cancel(boolean mayInterruptIfRunning) {
                return false;
            }

            @Override
            public boolean isCancelled() {
                return false;
            }

            @Override
            public boolean isDone() {
                return false;
            }

            @Override
            public Integer get() throws InterruptedException, ExecutionException {
                return i;
            }

            @Override
            public Integer get(long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {
                return null;
            }

            @Override
            public void run() {
                i++;
            }
        };

        ScheduledFuture<?> schedule = executor.schedule(runnableFuture, 1, TimeUnit.SECONDS);
        try {
            Thread.sleep(2000);
            System.out.println(schedule.get());
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        executor.schedule(()-> System.out.println(2), 2 ,TimeUnit.SECONDS);
        executor.schedule(()-> System.out.println(3), 3 ,TimeUnit.SECONDS);
        executor.schedule(()-> System.out.println(4), 4 ,TimeUnit.SECONDS);
        executor.awaitTermination(4, TimeUnit.SECONDS);
        executor.shutdown();
//        Thread thread = new Thread(() -> {
//            int v = 1;
//        });
//        thread.start();
//        thread.join();
//        System.out.println(v);

//        Timer timer = new Timer();
//            test();

//        1.CompletableFuture
//        CompletableFuture<Void> future = CompletableFuture.runAsync(() -> System.out.println(1 / 0));
//        List<CompletableFuture<Void>> onLineQueryTaskList = new ArrayList<>();
//        onLineQueryTaskList.add(future);
//        System.out.println(CollectionUtils.isEmpty(onLineQueryTaskList));
//
//        CompletableFuture.allOf(onLineQueryTaskList.toArray(new CompletableFuture[0])).join();

//        CompletableFuture<String> runA = CompletableFuture.supplyAsync(() -> {
//            try {
//                System.out.println("a");
//                Thread.sleep(2000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            return "a";
//        });
//
//        CompletableFuture<String> runB = CompletableFuture.supplyAsync(() -> {
//            try {
//                System.out.println("b");
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            return "b";
//        });
//
//        CompletableFuture<Object> future = runA.thenCombine(runB, (a , b) -> {
//            System.out.println(a + b);
//            return "a";
//        });
//
//

//        CompletableFuture.supplyAsync(()-> 1)
//                .thenApply((r)-> r/0)
//                .exceptionally(s->2)
//                .whenComplete((a, t)-> {
//                    System.out.println(a);
//                });

//        future.join();

//        ExecutorService executorService = Executors.newFixedThreadPool(10);
//
////        Future future = executorService.submit((Callable) () -> 1);
//
//        LinkedBlockingQueue<Integer> queue = new LinkedBlockingQueue<>();
//
//
//        ExecutorCompletionService<Object> completionService = new ExecutorCompletionService<>(executorService);
//
//        ArrayList<Future<Object>> futures = new ArrayList<>();
//
//
//        futures.add(completionService.submit(() -> {
//            Thread.sleep(1000);
//            return 1;
//        }));
//
//        futures.add(completionService.submit(() -> {
//            Thread.sleep(2000);
//            return 2;
//        }));
//
//        futures.add(completionService.submit(() -> {
//            Thread.sleep(3000);
//            return 3;
//        }));
//
//        for (int i=0;i<3;i++) {
//            Future<Object> take = completionService.take();
//            try {
//                Object o = take.get();
//                if (o != null) {
//                    System.out.println(take.get());
//                    break;
//                }
//            } catch (ExecutionException e) {
//                e.printStackTrace();
//            } finally {
//                for (Future future : futures) {
//                    future.cancel(true);
//                }
//            }
//        }


//
//        executorService.execute(()-> {
//            try {
//                queue.put(1);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        });
//
//        executorService.execute(()-> {
//            try {
//                queue.put(2);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        });
//
//
//        executorService.execute(()-> {
//            try {
//                queue.put(3);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        });
////        System.out.println(queue.size());
//        for (int i=0;i<3;i++) {
//            System.out.println(queue.take());
//        }


//        try {
//            future.get();
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        }

//        Future<Class<Integer>> future = executorService.submit(System.out::println, Integer.class);
//
//        AtomicInteger atomicInteger = new AtomicInteger();
//
//        ReentrantLock lock = new ReentrantLock();
//
//        long start = System.currentTimeMillis();
//        for (int i = 0; i < 20; i++) {
//            Thread r = new Thread(() -> {
////                lock.lock();
//
//                    for (int j = 0; j < 10000; j++) {
//                        num++;
////                    num.getAndIncrement();
//                }
////                lock.unlock();
////                atomicInteger.getAndIncrement();
//            });
//            r.start();
//        }
//        while (Thread.activeCount() > 1) {
//            Thread.yield();
//        }
//        System.out.println(System.currentTimeMillis() - start);
//        System.out.println(num);
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
