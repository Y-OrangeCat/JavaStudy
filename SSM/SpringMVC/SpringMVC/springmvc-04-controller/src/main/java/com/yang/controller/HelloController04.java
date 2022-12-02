package com.yang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HelloController04 {
    @RequestMapping(value = "/sum/{a}/{b}", method = RequestMethod.POST)
    //RestFul 风格:在Spring MVC中可以使用 @PathVariable 注解，让方法参数的值对应绑定到一个URI模板变量上
    public String test01(@PathVariable int a, @PathVariable int b, Model model) {
        int sum = 3 + 6;
        model.addAttribute("msg", "方法一的结果为：" + sum);
        return "hello";
    }

    //使用RESTful操作资源** ：可以通过不同的请求方式来实现不同的效果！如下：请求地址一样，但是功能可以不同！
    //http://localhost:8080/springmvc_04_controller/sum1/1/6
    @RequestMapping("/sum1/{a}/{b}")
    public String test02(@PathVariable int a, @PathVariable int b, Model model) {
        int sum = a + b;
        model.addAttribute("msg", "方法二的结果为：" + sum);
        return "hello";
    }

    @PostMapping("/sum1/{a}/{b}")
    public String test03(@PathVariable int a, @PathVariable int b, Model model) {
        int sum = a + b;
        model.addAttribute("msg", "方法三的结果为：" + sum);
        return "hello";
    }
}
