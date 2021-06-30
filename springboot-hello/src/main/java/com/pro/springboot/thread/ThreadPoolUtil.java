package com.pro.springboot.thread;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ThreadPoolExecutor;

@Slf4j
@Configuration
@EnableAsync
public class ThreadPoolUtil {
    @Value("${thread.pool.threadNamePrefix}")
    private String threadNamePrefix;
    @Value("${thread.pool.corePoolSize}")
    private int corePoolSize;
    @Value("${thread.pool.maxPoolSize}")
    private int maxPoolSize;
    @Value("${thread.pool.queueCapacity}")
    private int queueCapacity;
    @Value("${thread.pool.keepAliveSeconds}")
    private int keepAliveSeconds;
    private int awaitTerminationMillis = 60;
    private boolean waitForJobsToCompleteOnShutdown = Boolean.TRUE;

    private ThreadPoolTaskExecutor threadPool = new ThreadPoolTaskExecutor();

    @Bean("taskExecutor")
    public ThreadPoolTaskExecutor taskExecutor() {
        threadPool.setCorePoolSize(corePoolSize);
        threadPool.setMaxPoolSize(maxPoolSize);
        threadPool.setQueueCapacity(queueCapacity);
        threadPool.setWaitForTasksToCompleteOnShutdown(waitForJobsToCompleteOnShutdown);
        threadPool.setAwaitTerminationSeconds(awaitTerminationMillis);
        threadPool.setKeepAliveSeconds(keepAliveSeconds);
        threadPool.setThreadNamePrefix(threadNamePrefix);
        //rejection-policy：当pool已经达到max size的时候，如何处理新任务
        //CALLER_RUNS：不在新线程中执行任务，而是有调用者所在的线程来执行
        threadPool.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        threadPool.setThreadNamePrefix(threadNamePrefix);//  线程名称前缀
        threadPool.initialize();
        return threadPool;
    }

    public void excute(Runnable task)
    {
        threadPool.execute(task);
    }

    public void shutdown()
    {
        threadPool.shutdown();
    }
}
