package com.yang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ModelTest {

    @RequestMapping("/m1/t1")
    public String test1(Model model) {
        model.addAttribute("msg", "ModelTest1");
        //转发
        //通过SpringMVC来实现转发和重定向 - 无需视图解析器；测试前，需要将视图解析器注释掉
        return "/WEB-INF/jsp/hello.jsp";
    }

    @RequestMapping("/m1/t2")
    public String test2(Model model) {
        model.addAttribute("msg", "ModelTest2");
        //转发二
        return "forward:/WEB-INF/jsp/hello.jsp";
    }

    @RequestMapping("/m1/t3")
    public String test3() {
        //重定向（重定向不受视图解析器的影响）
        return "redirect:/index.jsp";
    }
}
