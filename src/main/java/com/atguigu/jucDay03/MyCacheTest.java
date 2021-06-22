package com.atguigu.jucDay03;

import sun.font.FontRunIterator;

import java.util.HashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author lbstart
 * @create 2021-06-20 11:06
 */
class MyCache {
    volatile HashMap<String,String> hashMap = new HashMap();
    ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();

    public void write(String key, String value) {
        try {
            reentrantReadWriteLock.writeLock().lock();
            System.out.println(Thread.currentThread().getName() + "\t" + "...写入开始");
            hashMap.put(key, value);
            System.out.println(Thread.currentThread().getName() + "\t" + "...写入结束");
        } finally {
            reentrantReadWriteLock.writeLock().unlock();
        }
    }
    public void read(String key) {
        try {
            reentrantReadWriteLock.readLock().lock();
            System.out.println(Thread.currentThread().getName() + "\t" + "...读取开始");
            String s = hashMap.get(key);
            System.out.println(Thread.currentThread().getName()+"\t"+"读取结束"+s);
        } finally {
            reentrantReadWriteLock.readLock().unlock();
        }
    }
}
public class MyCacheTest{
    public static void main(String[] args) {
        MyCache myCache = new MyCache();
        for (int i = 0; i < 10; i++) {
            final int a = i;
            new Thread(()->{
                myCache.write(a+"",a+"");
            },String.valueOf(a)).start();
        }
        for (int i = 0; i < 10; i++) {
            int b = i;
            new Thread(()->{
                myCache.read(b+"");
            },String.valueOf(b)).start();
        }
    }
}
