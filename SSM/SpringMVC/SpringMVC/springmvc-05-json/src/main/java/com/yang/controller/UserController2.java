package com.yang.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.yang.pojo.User;
import com.yang.utils.JsonUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class UserController2 {
    @RequestMapping("/j21")
    public String json1() throws JsonProcessingException {
        List<User> list = new ArrayList<>();
        //创建一个对象
        User user1 = new User(1, "莱莱", 17);
        User user2 = new User(2, "盈盈", 18);
        User user3 = new User(3, "冰冰", 19);
        list.add(user1);
        list.add(user2);
        list.add(user3);

        return JsonUtils.getJson(list);
    }

    @RequestMapping("/j22")
    public String json2(){

        Date date = new Date();
        return JsonUtils.getJson(date,"yyyy-MM-dd HH:mm:ss");
    }

    @RequestMapping("/j23")
    public String json3(){
        List<User> list = new ArrayList<>();
        //创建一个对象
        User user1 = new User(1, "莱莱", 17);
        User user2 = new User(2, "盈盈", 18);
        User user3 = new User(3, "冰冰", 19);
        list.add(user1);
        list.add(user2);
        list.add(user3);

        System.out.println("*******Java对象 转 JSON字符串*******");
        String str1 = JSON.toJSONString(list);
        System.out.println("JSON.toJSONString(list)==>"+str1);
        String str2 = JSON.toJSONString(user1);
        System.out.println("JSON.toJSONString(user1)==>"+str2);

        System.out.println("\n****** JSON字符串 转 Java对象*******");
        User jp_user1=JSON.parseObject(str2,User.class);
        System.out.println("JSON.parseObject(str2,User.class)==>"+jp_user1);

        System.out.println("\n****** Java对象 转 JSON对象 ******");
        JSONObject jsonObject1 = (JSONObject) JSON.toJSON(user2);
        System.out.println("(JSONObject) JSON.toJSON(user2)==>"+jsonObject1.getString("name"));

        System.out.println("\n****** JSON对象 转 Java对象 ******");
        User to_java_user = JSON.toJavaObject(jsonObject1, User.class);
        System.out.println("JSON.toJavaObject(jsonObject1, User.class)==>"+to_java_user);

        return JSON.toJSONString(list);
    }
}
