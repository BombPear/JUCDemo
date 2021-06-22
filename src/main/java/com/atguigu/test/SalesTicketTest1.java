package com.atguigu.test;

import com.atguigu.bean.Ticket;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author lbstart
 * @create 2021-06-18 16:03
 */
public class SalesTicketTest1 {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        Ticket ticket = new Ticket(50);
        try {
            executorService.submit(()-> {
                while (ticket.getNum() > 0) {
                    ticket.sale();
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            executorService.shutdown();
        }
    }
}
