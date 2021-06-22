package com.atguigu;

import java.util.*;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @author lbstart
 * @create 2021-06-18 20:22
 */
public class NotSafeDemo {
    public static void main(String[] args) {
//        Set<String> set = new CopyOnWriteArraySet<>();
        Set<Object> set = Collections.synchronizedSet(new HashSet<>());
        for (int i = 0; i < 30; i++) {
            new Thread(()->{
                set.add(UUID.randomUUID().toString().substring(0,6));
                System.out.println(set);
            },String.valueOf(i)).start();
        }
        System.out.println("李保牛比");
        System.out.println("李保真棒");
    }


}
