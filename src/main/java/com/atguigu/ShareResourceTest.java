package com.atguigu;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author lbstart
 * @create 2021-06-18 21:29
 */
class ShareResource {
    int flag = 1;
    Lock lock = new ReentrantLock();
    Condition condition1 = lock.newCondition();
    Condition condition2 = lock.newCondition();
    Condition condition3 = lock.newCondition();

    public void print5() throws InterruptedException {
        lock.lock();
        try {
            while (flag!=1) {
                condition1.await();
            }
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName()+"" +
                        "\t"+i);
            }
            flag = 2;
            condition2.signal();
        } finally {
            lock.unlock();
        }
    }
    public void print10() throws InterruptedException {
        lock.lock();
        try {
            while (flag!=2) {
                condition2.await();
            }
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName()+"" +
                        "\t"+i);
            }
            flag = 3;
            condition3.signal();
        } finally {
            lock.unlock();
        }
    }public void print15() throws InterruptedException {
        lock.lock();
        try {
            while (flag!=3) {
                condition3.await();
            }
            for (int i = 0; i < 15; i++) {
                System.out.println(Thread.currentThread().getName()+"" +
                        "\t"+i);
            }
            flag = 3;
            condition1.signal();
        } finally {
            lock.unlock();

        }
    }
}

public class ShareResourceTest{
    public static void main(String[] args) {
        ShareResource shareResource = new ShareResource();
        new Thread(()->{
            try {
                shareResource.print15();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"B").start();
        new Thread(()->{
            try {
                shareResource.print5();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"A").start();
        new Thread(()->{
            try {
                shareResource.print10();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"c").start();

    }
}
