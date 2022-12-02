package com.yang.config;

import com.yang.pojo.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

//这个也被Spring容器托管，注册到容器里，因为他本来就是一个@Component，
// @Component代表这是一个配置类，就和我们之前看的beans.xml是一样的
@Configuration
//显式的扫描包，可不写
@ComponentScan("com.yang.pojo")
@Import(UserConfig2.class)
public class UserConfig {
    //注册一个bean，就相当于我们之前写的一个bean标签，
    //这个方法的名字getUser就相当于bean标签的id属性
    //这个方法的返回值,就相当于bean标签中的class属性
    @Bean
    public User getUser(){
        return new User();
    }
}
