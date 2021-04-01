package com.hxh.hxh_gateway.hxh_gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class HxhGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(HxhGatewayApplication.class, args);
    }

}
