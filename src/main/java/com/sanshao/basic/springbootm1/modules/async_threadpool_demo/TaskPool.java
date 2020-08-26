package com.sanshao.basic.springbootm1.modules.async_threadpool_demo;


import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

@Slf4j
@Component
public class TaskPool {
    @Async("taskExecutor")
    public Future<String> task(String num) throws InterruptedException {
        log.info("任务开始并延长执行时间");
        TimeUnit.MILLISECONDS.sleep(1000);
        log.info(num);
        return new AsyncResult<String>("complete!");
    }
}
