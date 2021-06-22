package com.atguigu.jucDay03;

import java.util.concurrent.*;

/**
 * @author lbstart
 * @create 2021-06-20 15:43
 */
public class ThreadPoolDemo {
    public static void main(String[] args) {
        ExecutorService threadPool = new ThreadPoolExecutor(
                2,
                5,
                1L,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.DiscardOldestPolicy()
        );
        try {
            for (int i = 0; i < 16; i++) {
                int finali = i;
                threadPool.submit(()->{
                    System.out.println(Thread.currentThread().getName()+"\t"+"为顾客"+finali+"办理业务");
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            threadPool.shutdown();
        }
    }


}
