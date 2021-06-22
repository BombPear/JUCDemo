package com.atguigu.test;

import com.atguigu.bean.Ticket;
import com.atguigu.bean.Tickets;
import org.junit.Test;

/**
 * @author lbstart
 * @create 2021-06-16 19:38
 */
public class SalesTicketTest {
    Tickets tickets = new Tickets(50);
    /*

    */
    @Test
    public void test(){
        /*new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    tickets.sales();
                }
            }
        },"A").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    tickets.sales();
                }
            }
        },"B").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    tickets.sales();
                }
            }
        },"C").start();*/
        new Thread(()->{while (true){tickets.sales();}},"A").start();
        new Thread(()->{while (true){tickets.sales();}},"B").start();
        new Thread(()->{while (true){tickets.sales();}},"C").start();


    }
}
