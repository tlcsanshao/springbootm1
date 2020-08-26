package com.sanshao.basic.springbootm1.modules.schedule_demo;


import org.springframework.scheduling.annotation.Scheduled;

//@Component
public class ScheduleService{

    @Scheduled(fixedDelay = 30000)
    public void task1() {
        System.out.println("This is Task1");
    }

    @Scheduled(fixedRate = 10000)
    public void task2() {
        System.out.println("This is Task2");
    }
}
