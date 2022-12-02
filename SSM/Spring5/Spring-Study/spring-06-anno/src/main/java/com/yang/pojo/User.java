package com.yang.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
//等价于<bean id="user" class="com.yang.pojo.User"/>
@Component
public class User {
    //相当于<property name="name" value="范俊峰"/>
    @Value("范俊峰")
    public String name;
}
