package com.atguigu;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author lbstart
 * @create 2021-06-18 20:31
 */
public class ProduceConsumerDemo {
    public static void main(String[] args) {
        Aircondication aircondication = new Aircondication();
        new Thread(()->{
            for (int i = 1; i <= 10; i++) {
                try {
                    aircondication.increatment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"A").start();
        new Thread(()->{
            for (int i = 1; i <= 10; i++) {
                try {
                    aircondication.decreatment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"B").start();
        new Thread(()->{
            for (int i = 1; i <= 10; i++) {
                try {
                    aircondication.decreatment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"C").start();
        new Thread(()->{
            for (int i = 1; i <= 10; i++) {
                try {
                    aircondication.decreatment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"D").start();
    }
}
class Aircondication{
     int temperature = 0;
    Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();
    public void increatment() throws InterruptedException {
        lock.lock();
        try {
            while (temperature != 0) {
                condition.await();
            }
            ++temperature;
            System.out.println(Thread.currentThread().getName()+"\t"+temperature);
            condition.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public void decreatment() throws InterruptedException{
        lock.lock();
        try {
            while (temperature==0) {
                condition.await();
            }
            --temperature;
            System.out.println(Thread.currentThread().getName()+"\t"+temperature);
            condition.signalAll();
        } finally {
            lock.unlock();
        }
    }
}

