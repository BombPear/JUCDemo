package com.atguigu.jucDay3CopyTeacher;

import java.util.concurrent.CountDownLatch;

/**
 * @author lbstart
 * @create 2021-06-19 0:02
 */
public class CountDownLatchDemo {
    public static void main(String[] args) throws InterruptedException
    {

        CountDownLatch countDownLatch = new CountDownLatch(6);


        for (int i = 1; i <=6; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName()+"\t"+"---离开教室");
                countDownLatch.countDown();
            },String.valueOf(i)).start();
        }
        countDownLatch.await();


        System.out.println(Thread.currentThread().getName()+"\t"+"---关门走人");
    }
}
