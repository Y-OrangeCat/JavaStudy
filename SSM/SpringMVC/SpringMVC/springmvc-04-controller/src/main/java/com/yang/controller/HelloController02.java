package com.yang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class HelloController02 {
    @RequestMapping("/t1")
    public String test01(Model model){
        model.addAttribute("msg","Controller注解：test01");
        return "hello";
    }

    @RequestMapping("t2")
    public String test02(Model model){
        model.addAttribute("msg","Controller注解：test02");
        return "hello";
    }
}
