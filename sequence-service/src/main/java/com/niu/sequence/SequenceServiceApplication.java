package com.niu.sequence;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com")
public class SequenceServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SequenceServiceApplication.class, args);
    }

}
