package com.sanshao.basic.springbootm1.modules.async_threadpool_demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

@Slf4j
@RestController
public class TaskExecutorController {

    @Autowired
    TaskPool taskPollDemo;


    @RequestMapping("/tasktp")
    public String doTask() throws Exception {
        List<Future<String>> list = new ArrayList<Future<String>>();
        for (int i = 0; i < 30; i++) {
            list.add(taskPollDemo.task("task-" + i));
        }
        while (true) {
            for (Future<String> futureItem : list) {
                if (!futureItem.isDone()) {
                    TimeUnit.SECONDS.sleep(1);
                    continue;
                }
            }
            break;
        }

        return "tasktp";
    }
}
