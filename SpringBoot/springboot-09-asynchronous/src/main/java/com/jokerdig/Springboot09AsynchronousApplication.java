package com.jokerdig;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

// 开启异步任务注解
@EnableAsync
@SpringBootApplication
public class Springboot09AsynchronousApplication {

    public static void main(String[] args) {
        SpringApplication.run(Springboot09AsynchronousApplication.class, args);
    }

}
