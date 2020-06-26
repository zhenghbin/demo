package com.example.demo.concurrent;

import com.example.demo.DemoApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class)
public class CalcNumThreadTest {

    @Resource(name = "ExecutorT")
    private ExecutorService executor;

    @Autowired
    private CalcNumThread calcNumThread;

    private static int j = 0;

    //模拟请求次数
    private static final int MAX_REQUEST_COUNT=1000;

    private static CountDownLatch cdl = new CountDownLatch(MAX_REQUEST_COUNT);

    @Test
    public void test() throws InterruptedException {
        for (int i=0;i<MAX_REQUEST_COUNT;i++) {
            executor.execute(calcNumThread);
//            Thread thread = new Thread(() -> {
//                cdl.countDown();//递减1
//
//                try {
//                    cdl.await();//等待
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                j++;
//            });
//            thread.start();
        }
//        calcNumThread.run();
        //主线程休息，为了让计数程序走完
        Thread.sleep(3000);
        System.out.println(calcNumThread.getI());
    }


}
