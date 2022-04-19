package com.bootdo.train.mutiltread;

public class Producer implements Runnable {
    SyncStack syncStack;

    Producer(SyncStack syncStack) {
        this.syncStack = syncStack;
    }

    @Override
    public void run() {
        char c;
        for (int i = 0; i < 10; i++) {
            c = (char) (Math.random() * 26 + 'A');
            // 入栈字符c
            syncStack.push(c);
            // 打印字符
            System.out.println("Produced:" + c);
            try {
                Thread.sleep((int) (Math.random() * 1000));
            } catch (InterruptedException e) {
            }
        }
    }
}
