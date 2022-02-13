package com.bootdo.common.lock;

import java.util.concurrent.atomic.AtomicInteger;

public class ThreeThreadSout {

    static AtomicInteger num = new AtomicInteger(0);

    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            Thread t = new Thread(() -> {
                while (num.get() < 1000) {
                    System.out.println("This Thread:" + Thread.currentThread().getName() + " num:" + num.getAndIncrement());
                }
            });
            t.start();
        }
    }

}
