package com.atguigu.jucDay03;

import java.util.Currency;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author lbstart
 * @create 2021-06-20 14:51
 */
public class CyclicBarrierDemo {
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(7,()->{
            System.out.println(Thread.currentThread().getName()+"\t"+"召唤神龙");
        });
        for (int i = 0; i < 7; i++) {
            int finali = i;
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+"\t"+"收集到："+finali);
                try {
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
