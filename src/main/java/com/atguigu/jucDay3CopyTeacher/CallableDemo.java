package com.atguigu.jucDay3CopyTeacher;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/**
 * @author lbstart
 * @create 2021-06-18 23:37
 */
public class CallableDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<String> futureTask = new FutureTask<>(new MyThread());
        new Thread(futureTask,"t").start();
        System.out.println(Thread.currentThread().getName()+"\t"+"------do...in");
        System.out.println(futureTask.get());
    }
}


class MyThread implements Callable<String> {
    @Override
    public String call() throws Exception {
        System.out.println("------come in");
        TimeUnit.SECONDS.sleep(3);
        return "hello";
    }
}
