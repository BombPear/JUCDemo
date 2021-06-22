package com.atguigu.bean;

import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author lbstart
 * @create 2021-06-16 18:48
 */
public class Ticket {
    private int num;

    public Ticket(int num) {
        this.num = num;
    }

    public Ticket() {
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

//    public synchronized void sale(){
//        if (num>0) {
//            System.out.println(Thread.currentThread().getName() + "卖出第" + num + "张票");
//            num--;
//        }
//    }

    private final ReentrantLock lock = new ReentrantLock();

    public void sale(){
        lock.lock();
        try {

                System.out.println(Thread.currentThread().getName() + "卖出第" + num + "张票");
                num--;

        } finally {
            lock.unlock();
        }
    }
}
