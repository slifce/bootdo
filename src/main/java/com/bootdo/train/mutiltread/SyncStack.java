package com.bootdo.train.mutiltread;

// 同步堆栈类
public class SyncStack {
    // 堆栈指针初始值为0
    private int index = 0;
    // 堆栈有6个字符空间
    private char[] buffer = new char[6];

    // 加上互斥锁synchronized
    public synchronized void push(char c) {
        // 堆栈已满，不能压栈
        while (index == buffer.length) {
            try {
                // 等待，直到有数据出栈
                this.wait();
            } catch (InterruptedException e) {

            }
        }
        // 通知其他线程把数据出栈
        this.notify();
        // 数据入栈
        buffer[index] = c;
        // 指针向上移动
        index++;
    }

    // 加上互斥锁synchronized
    public synchronized char pop() {
        // 堆栈为空，不能出栈
        while (index == 0) {
            try {
                // 等待，直到有数据入栈
                this.wait();
            } catch (InterruptedException e) {

            }
        }
        // 通知其他线程把数据入栈
        this.notify();
        // 指针向下移动
        index--;
        // 数据出栈
        return buffer[index];
    }

}
