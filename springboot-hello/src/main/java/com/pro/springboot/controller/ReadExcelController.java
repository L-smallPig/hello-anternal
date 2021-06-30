package com.pro.springboot.controller;

import com.pro.springboot.result.Result;
import com.pro.springboot.thread.DemoTask;
import com.pro.springboot.thread.ThreadPoolUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Description 生成建表语句和字段注释
 * @Author liguangyue [10733]
 * @Date 2020-12-01
 * @Copyright 2020-2025
 */
@RestController
@RequestMapping("/outer/thread")
public class ReadExcelController {

    /**
     * 日志
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(ReadExcelController.class);

    @Value("${thread.pool.corePoolSize}")
    private int corePoolSize;

    @Resource
    private ThreadPoolUtil threadPoolUtil;

    /**
     *
     * @return
     */
    @ResponseBody
    @PostMapping("/testThread")
    public Result testThread()
    {
        LOGGER.info("线程开始");
        final CountDownLatch cdOrder = new CountDownLatch(1);
        final CountDownLatch cdAnswer = new CountDownLatch(4);
        List<String> list = new ArrayList();
        for (int i = 0; i < 4; i++) {
            threadPoolUtil.excute(new DemoTask(cdOrder,cdAnswer));
            list.add("aa");
        }

        try{
            Thread.sleep((long) (Math.random() * 10000));
            System.out.println("裁判"+Thread.currentThread().getName()+"即将发布口令");
            cdOrder.countDown();
            System.out.println("裁判"+Thread.currentThread().getName()+"已发送口令，正在等待所有选手到达终点");
            cdAnswer.await();
            System.out.println("所有选手都到达终点");
            System.out.println("裁判"+Thread.currentThread().getName()+"汇总成绩排名");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        threadPoolUtil.shutdown();
        return Result.success(list);
    }

    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newFixedThreadPool(10);
        final CountDownLatch cdOrder = new CountDownLatch(1);
        final CountDownLatch cdAnswer = new CountDownLatch(4);
        List<String> list = new ArrayList();
        for (int i = 0; i < 4; i++) {
            threadPool.execute(new DemoTask(cdOrder,cdAnswer));
            list.add("aa");
        }

        try {
            Thread.sleep((long) (Math.random() * 10000));
            System.out.println("裁判"+Thread.currentThread().getName()+"即将发布口令");
            cdOrder.countDown();
            System.out.println("裁判"+Thread.currentThread().getName()+"已发送口令，正在等待所有选手到达终点");
            cdAnswer.await();
            System.out.println("所有选手都到达终点");
            System.out.println("裁判"+Thread.currentThread().getName()+"汇总成绩排名");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        threadPool.shutdown();
    }
}
