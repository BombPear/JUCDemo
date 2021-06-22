package com.atguigu.jucDay03;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author lbstart
 * @create 2021-06-20 10:24
 */
class Mythread implements Callable {
    @Override
    public Object call() throws Exception {
        return 3;
    }
}
public class CallableTest{
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Mythread mythread = new Mythread();
        FutureTask futureTask = new FutureTask(mythread);
        new Thread(futureTask,"A").start();
        System.out.println(futureTask.get());
    }
}
