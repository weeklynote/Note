package com.develope.note.guava;

import com.google.common.util.concurrent.RateLimiter;

import java.util.concurrent.CountDownLatch;

/**
 * 本实例演示基于令牌桶的限流方式
 *
 * <dependency>
 * <groupId>com.google.guava</groupId>
 * <artifactId>guava</artifactId>
 * <version>18.0</version>
 * </dependency>
 */
public class GuavaTest {

    private RateLimiter rateLimiter = RateLimiter.create(10);

    public void run(){
        if (rateLimiter.tryAcquire()){
            System.out.println(Thread.currentThread().getName() + "<>调用成功！");
        }else {
            System.out.println(Thread.currentThread().getName() + "<>调用失败！");
        }
    }

    public static void main(String[] args) {
        GuavaTest guavaTest = new GuavaTest();
        CountDownLatch countDownLatch = new CountDownLatch(1);
        for (int i = 0; i < 20; i++){
            Thread t1 = new Thread(() -> {
                try {
                    countDownLatch.await();
                    guavaTest.run();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            t1.start();
        }
        System.out.println("start....");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        countDownLatch.countDown();
    }

}
