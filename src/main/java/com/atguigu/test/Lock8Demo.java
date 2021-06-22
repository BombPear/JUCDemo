package com.atguigu.test;

import java.util.Collections;
import java.util.concurrent.TimeUnit;

/**
 * @author lbstart
 * @create 2021-06-18 18:46
 */
public class Lock8Demo {
    public static void main(String[] args) {
        Phone phone1 = new Phone();
        Phone phone2 = new Phone();
        new Thread(()->{
            phone1.sendEmail();
//            phone1.sendSMS();
        },"A").start();
        new Thread(()->{
            phone1.sendSMS();
//            phone1.hello();
        }).start();
    }
}

class Phone{
    public  static synchronized void sendEmail(){
        try {
            TimeUnit.SECONDS.sleep(3);
            System.out.println("email");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//                    System.out.println("email");

    }
    public synchronized void sendSMS(){
        System.out.println("sms");
    }

    public void hello(){
        System.out.println("hello");
    }
}
