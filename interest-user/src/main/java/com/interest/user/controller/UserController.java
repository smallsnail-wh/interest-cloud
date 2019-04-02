package com.interest.user.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping("/public/test")
    public String test1(){
        return "/public/test SUCCESS";
    }

    @GetMapping("/test")
    public String test2(){
        return "/test SUCCESS";
    }

}
