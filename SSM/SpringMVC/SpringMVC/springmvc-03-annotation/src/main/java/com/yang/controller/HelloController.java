package com.yang.controller;

import org.junit.Test;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

//@Controller注解的类会自动添加到Spring上下文中
@Controller
public class HelloController {
    @RequestMapping("/h1")
    public String show1(Model model){
        //向模型中添加属性msg与值，可以在JSP页面中取出并渲染
        model.addAttribute("msg","Hello SpringMVC Annotation");

        //返回视图位置：web-inf/jsp/hello.jsp
        return "hello";
    }
}
