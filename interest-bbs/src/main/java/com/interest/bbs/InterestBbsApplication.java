package com.interest.bbs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.interest.bbs","com.interest.common"})
public class InterestBbsApplication {

    public static void main(String[] args) {
        SpringApplication.run(InterestBbsApplication.class, args);
    }

}
