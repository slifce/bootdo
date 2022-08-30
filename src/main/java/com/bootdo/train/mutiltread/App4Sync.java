package com.bootdo.train.mutiltread;

public class App4Sync {

    public static void main(String[] args) {
        SyncStack syncStack = new SyncStack();
        Producer producer = new Producer(syncStack);
        Consumer consumer = new Consumer(syncStack);
        Thread pt = new Thread(producer);
        Thread ct = new Thread(consumer);
        pt.start();
        ct.start();
    }
}
