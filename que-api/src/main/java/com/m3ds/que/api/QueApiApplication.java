package com.m3ds.que.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
@ComponentScan("com.m3ds.que.*")
public class QueApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(QueApiApplication.class, args);
    }

}
