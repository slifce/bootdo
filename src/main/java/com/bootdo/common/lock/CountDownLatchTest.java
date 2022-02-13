package com.bootdo.common.lock;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CountDownLatch;

/**
 * 分7个子任务执行收集龙珠，然后完成以后召唤神龙
 */
public class CountDownLatchTest {

    private final static Random random = new Random();

    static class SearchTask implements Runnable{
        private Integer id;
        private CountDownLatch latch;

        public SearchTask(Integer id,CountDownLatch latch){
            this.id = id;
            this.latch = latch;
        }

        @Override
        public void run() {
            System.out.println("开始寻找"+id+"号龙珠");
            int seconds = random.nextInt(10);
            try {
                Thread.sleep(seconds*1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("花了"+seconds+"s,找到了"+id+"号龙珠");
            latch.countDown();
        }
    }

    public static void main(String[] args) {
        List<Integer> idList = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        CountDownLatch latch = new CountDownLatch(idList.size());
        for (Integer id :idList){
            Thread thread = new Thread(new SearchTask(id, latch));
            thread.start();
        }
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("已经找到所有龙珠，可以召唤神龙了...");
    }

}
