package com.sanshao.basic.springbootm1.modules.async_demo;


import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

@Component
public class AsyncTask {

    @Async
    public Future<String> task1() throws InterruptedException {
        long currentTimeMillis = System.currentTimeMillis();
        TimeUnit.MILLISECONDS.sleep(1000);
        long currentTimeMillis1 = System.currentTimeMillis();
        System.out.println("Task1 Spends Time:" + (currentTimeMillis1 - currentTimeMillis)+" ms");
        return new AsyncResult<String>("task1 completes");
    }

    @Async
    public Future<String> task2() throws InterruptedException {
        long currentTimeMillis = System.currentTimeMillis();
        TimeUnit.MILLISECONDS.sleep(2000);
        long currentTimeMillis1 = System.currentTimeMillis();
        System.out.println("Task2 Spends Time:" + (currentTimeMillis1 - currentTimeMillis)+" ms");
        return new AsyncResult<String>("task2 completes");
    }

    @Async
    public Future<String> task3() throws InterruptedException {
        long currentTimeMillis = System.currentTimeMillis();
        TimeUnit.MILLISECONDS.sleep(3000);
        long currentTimeMillis1 = System.currentTimeMillis();
        System.out.println("Task3 Spends Time:" + (currentTimeMillis1 - currentTimeMillis)+" ms");
        return new AsyncResult<String>("task3 completes");
    }

}
