package com.atguigu.jucDay3CopyTeacher;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author lbstart
 * @create 2021-06-19 0:03
 */
public class CyclicBarrierDemo {
    public static void main(String[] args)
    {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(7,() -> {System.out.println(Thread.currentThread().getName()+"\t"+"---召唤神龙....");});


        for (int i = 1; i <=7; i++) {
            int finalI = i;
            new Thread(() -> {
                try {
                    System.out.println(Thread.currentThread().getName()+"\t"+"收集到： "+ finalI);
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            },String.valueOf(i)).start();
        }


    }
}
