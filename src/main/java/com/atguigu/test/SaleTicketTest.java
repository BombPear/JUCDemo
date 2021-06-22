package com.atguigu.test;

import com.atguigu.bean.Ticket;

/**
 * @author lbstart
 * @create 2021-06-16 18:48
 */
public class SaleTicketTest {
    public static void main(String[] args) {
        Ticket ticket = new Ticket(100);
        /*new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i < 101; i++){
                    ticket.sale();
                }
            }
        },"A").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i < 101; i++){
                    ticket.sale();
                }
            }
        },"C").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i < 101; i++){
                    ticket.sale();
                }
            }
        },"B").start();*/
        new Thread(()->{for (int i = 1; i < 101; i++){ticket.sale(); }},"A").start();
        new Thread(()->{for (int i = 1; i < 101; i++){ticket.sale(); }},"b").start();
        new Thread(()->{for (int i = 1; i < 101; i++){ticket.sale(); }},"c").start();
        new Thread(()->{for (int i = 1; i < 101; i++){ticket.sale(); }},"d").start();



    }
}
