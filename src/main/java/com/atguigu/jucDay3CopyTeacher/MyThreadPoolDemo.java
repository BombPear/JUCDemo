package com.atguigu.jucDay3CopyTeacher;

import java.util.concurrent.*;

/**
 * @author lbstart
 * @create 2021-06-19 0:10
 */
public class MyThreadPoolDemo {
    public static void main(String[] args)
    {
        ExecutorService threadPool = new ThreadPoolExecutor(
                2,
                5,
                1L,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.DiscardOldestPolicy());

        try
        {
            for (int i = 1; i <=16; i++) {
                int finalI = i;
                threadPool.submit(() -> {
                    System.out.println(Thread.currentThread().getName()+"\t"+"为顾客："+ finalI +" 办理业务");
                    //try { TimeUnit.SECONDS.sleep(3); } catch (InterruptedException e) { e.printStackTrace(); }
                });
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            threadPool.shutdown();
        }
    }

    private static void initPool()
    {
        ExecutorService threadPool = Executors.newFixedThreadPool(5);//模拟银行，一店5窗口
        //ExecutorService threadPool = Executors.newSingleThreadExecutor();//一池一线程
        //ExecutorService threadPool = Executors.newCachedThreadPool();

        try
        {
            for (int i = 1; i <=20; i++) {
                int finalI = i;
                threadPool.submit(() -> {
                    System.out.println(Thread.currentThread().getName()+"\t"+"为顾客："+ finalI +"办理业务");
                });
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            threadPool.shutdown();
        }
    }
}
