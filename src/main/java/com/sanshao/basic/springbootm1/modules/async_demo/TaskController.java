package com.sanshao.basic.springbootm1.modules.async_demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

@RestController
public class TaskController {

    @Autowired
    public AsyncTask asyncTask;

    @RequestMapping("/task")
    public String doTask() throws InterruptedException{
        long currentTimeMillis = System.currentTimeMillis();
        Future<String> task1 = asyncTask.task1();
        Future<String> task2 = asyncTask.task2();
        Future<String> task3 = asyncTask.task3();

        String result = null;
        for(;;){
            if(task1.isDone()&& task2.isDone() && task3.isDone()){
                break;
            }
            TimeUnit.MILLISECONDS.sleep(100);
        }
        long currentTimeMillis1 = System.currentTimeMillis();
        result = "all tasks spend time:"+(currentTimeMillis1-currentTimeMillis)+" ms";
        return result;
    }
}
