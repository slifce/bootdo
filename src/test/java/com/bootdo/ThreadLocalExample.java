package com.bootdo;

public class ThreadLocalExample {

    ThreadLocal<Long> longLocal = new ThreadLocal<>();
    public void set() {
        longLocal.set(Thread.currentThread().getId());
    }
    public long getLong() {
        return longLocal.get();
    }
    public static void main(String[] args) {
        ThreadLocalExample test = new ThreadLocalExample();
        test.set();
        //注意:没有set之前，直接get，报null异常了
        System.out.println("-------threadLocal value-------" + test.getLong());
    }
}
