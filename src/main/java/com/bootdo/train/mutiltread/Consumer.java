package com.bootdo.train.mutiltread;

public class Consumer implements Runnable{
    SyncStack syncStack;
    Consumer(SyncStack syncStack){
        this.syncStack = syncStack;
    }

    @Override
    public void run() {
        char c;
        for (int i = 0; i < 10; i++) {
            // 从堆栈中读取字符
            c = syncStack.pop();
            System.out.println("Consumed:"+c);
            try {
                Thread.sleep((int)(Math.random()*1000));
            } catch (InterruptedException e) {
            }
        }
    }
}
