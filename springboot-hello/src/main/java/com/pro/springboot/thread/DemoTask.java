package com.pro.springboot.thread;

import java.util.concurrent.CountDownLatch;

/**
 * @Description 测试线程池
 * @Author liguangyue [10733]
 * @Date 2020-12-04
 * @Copyright 2020-2025
 */
public class DemoTask implements Runnable {

    private CountDownLatch cdOrder;
    private CountDownLatch cdAnswer;

    public DemoTask() {
    }

    public DemoTask(CountDownLatch cdOrder, CountDownLatch cdAnswer) {
        this.cdOrder = cdOrder;
        this.cdAnswer = cdAnswer;
    }

    @Override
    public void run() {
        try {
            System.out.println("选手" + Thread.currentThread().getName() + "正在等待裁判发布口令");
            cdOrder.await();
            System.out.println("选手" + Thread.currentThread().getName() + "已接受裁判口令");
            Thread.sleep((long) (Math.random() * 10000));
            System.out.println("选手" + Thread.currentThread().getName() + "到达终点");
            cdAnswer.countDown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
