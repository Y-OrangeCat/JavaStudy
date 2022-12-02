package com.yang.controller;

import com.yang.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {
    @RequestMapping("/u1")
    //@RequestParam("username") : username提交的域的名称.
    //http://localhost:8080/springmvc_04_controller/u1?username=冰冰
    public String user1(@RequestParam("username") String name, Model model) {
    //public String user1(String name, Model model)
        //后台显示
        System.out.println("name：" + name);
        //返回给前台页面
        model.addAttribute("msg", "name：" + name);
        return "hello";
    }

    @RequestMapping("/u2")
    public String user2(User user, Model model) {
        System.out.println("用户信息为：" + user);
        model.addAttribute("msg", "用户信息为：" + user);
        return "hello";
    }

    @GetMapping("/u3")
    public String user3(User user, ModelMap modelMap) {
        System.out.println("用户信息为：" + user);
        modelMap.addAttribute("msg", "用户信息为：" + user);
        return "hello";
    }
}
