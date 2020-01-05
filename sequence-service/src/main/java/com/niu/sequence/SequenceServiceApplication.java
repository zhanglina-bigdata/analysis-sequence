package com.niu.sequence;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.niu.sequence")
@EnableEurekaClient
@EnableFeignClients(basePackages = {"com.niu.sequence"})
@EnableDiscoveryClient
public class SequenceServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SequenceServiceApplication.class, args);
    }

}
