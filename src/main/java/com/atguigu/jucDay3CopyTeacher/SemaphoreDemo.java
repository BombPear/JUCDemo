package com.atguigu.jucDay3CopyTeacher;

import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @author lbstart
 * @create 2021-06-19 0:06
 */
public class SemaphoreDemo {
    public static void main(String[] args)
    {
        Semaphore semaphore = new Semaphore(3);//模拟有3个停车位+限流

        //6车抢3位
        for (int i = 1; i <=6; i++) {
            new Thread(() -> {
                boolean flag= false;
                try {
                    semaphore.acquire();
                    flag = true;
                    System.out.println(Thread.currentThread().getName()+"\t"+"---come in");
                    try { TimeUnit.SECONDS.sleep(new Random().nextInt(4)); } catch (InterruptedException e) { e.printStackTrace(); }
                    System.out.println(Thread.currentThread().getName()+"\t"+"---离开车位");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    if(flag)
                    {
                        semaphore.release();
                    }
                }
            },String.valueOf(i)).start();
        }
    }
}
