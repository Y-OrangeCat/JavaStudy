package com.yang.controller;

import com.yang.pojo.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class AjaxController {
    @RequestMapping("/t1")
    public String test1(){
        return "hello";
    }

    @RequestMapping("/a1")
    public void ajax1(String name,HttpServletResponse response) throws IOException {
        System.out.println("name:"+name);
        if ("admin".equals(name)){
            response.getWriter().print("true");
        }else {
            response.getWriter().print("false");
        }
    }

    @RequestMapping("/a2")
    public List<User> ajax2(){
        List<User> list=new ArrayList<>();
        list.add(new User("莱莱",18,"女"));
        list.add(new User("冰冰",19,"女"));
        list.add(new User("盈盈",17,"女"));
        //由于使用了@RequestMapping注解，将list转成json格式返回
        return list;
    }

    @RequestMapping("/a3")
    public String ajax3(String name,String pwd){
        String msg="";
        if (name!=null){
            if ("admin".equals(name)){
                msg="ok";
            }else {
                msg="用户名错误！";
            }
        }

        if (pwd!=null){
            if ("123456".equals(pwd)){
                msg="ok";
            }else {
                msg="密码错误！";
            }
        }
        return msg;
    }

}
