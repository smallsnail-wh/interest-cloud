package com.interest.blog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.interest.blog","com.interest.common"})
public class InterestBlogApplication {

    public static void main(String[] args) {
        SpringApplication.run(InterestBlogApplication.class, args);
    }

}
