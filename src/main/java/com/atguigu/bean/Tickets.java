package com.atguigu.bean;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author lbstart
 * @create 2021-06-16 19:34
 */
public class Tickets {
    private int ticket;

    public Tickets(int ticket) {
        this.ticket = ticket;
    }

    public Tickets() {
    }

    public int getTicket() {
        return ticket;
    }

    public void setTicket(int ticket) {
        this.ticket = ticket;
    }

    private final ReentrantLock lock = new ReentrantLock();
    public void sales(){
        lock.lock();
        try {
            if (ticket > 0) {
                System.out.println(Thread.currentThread().getName()+"卖出第"+ticket+"张票");
                ticket--;
            }
        } finally {
            lock.unlock();
        }
    }
}
