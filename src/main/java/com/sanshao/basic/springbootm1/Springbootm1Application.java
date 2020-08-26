package com.sanshao.basic.springbootm1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@EnableAsync
public class Springbootm1Application {

    public static void main(String[] args) {
        SpringApplication.run(Springbootm1Application.class, args);
    }

}
