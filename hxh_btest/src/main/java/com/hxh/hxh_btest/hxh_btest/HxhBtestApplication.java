package com.hxh.hxh_btest.hxh_btest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class HxhBtestApplication {

    public static void main(String[] args) {
        SpringApplication.run(HxhBtestApplication.class, args);
    }

}
