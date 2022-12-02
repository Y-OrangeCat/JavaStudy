package com.yang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestInterceptor {
    @GetMapping("/t1")
    public String test1(){
        System.out.println("执行了=>test1()方法！");
        return "你好";
    }
}
