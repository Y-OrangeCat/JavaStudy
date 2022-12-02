package com.yang.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.yang.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//@Controller
@RestController //返回json字符串
public class UserController {
    @RequestMapping("/j1")
//    @ResponseBody   //他就不会走视图解析器，会直接返回一个 字符串
    public String json1() throws JsonProcessingException {
        //jackson,ObjectMapper
        ObjectMapper mapper = new ObjectMapper();
        //创建一个对象
        User user = new User(1, "莱莱", 17);
        String str = mapper.writeValueAsString(user);

        return str;
    }

    @RequestMapping("/j2")
    public String json2() throws JsonProcessingException {
        //jackson,ObjectMapper
        ObjectMapper mapper = new ObjectMapper();
        List<User> list = new ArrayList<>();
        //创建一个对象
        User user1 = new User(1, "莱莱", 17);
        User user2 = new User(2, "盈盈", 18);
        User user3 = new User(3, "冰冰", 19);
        list.add(user1);
        list.add(user2);
        list.add(user3);

        String str = mapper.writeValueAsString(list);
        return str;
    }

    @RequestMapping("/j3")
    public String json3() throws JsonProcessingException {
        //jackson,ObjectMapper
        ObjectMapper mapper = new ObjectMapper();

        //不使用时间戳的方式
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        //自定义日期格式对象
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //指定日期格式
        mapper.setDateFormat(sdf);

        Date date = new Date();
        String time = mapper.writeValueAsString(date);

        return time;
    }
}
