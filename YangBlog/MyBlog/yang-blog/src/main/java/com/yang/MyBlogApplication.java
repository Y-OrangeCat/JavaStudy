package com.yang;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @Description: 项目启动类
 * @Author: Mr.Yang
 * @Date: 2022/11/22 18:14
 * @Version: 1.0
 */
@SpringBootApplication
@EnableScheduling   //开启定时任务
@EnableSwagger2     //开启Swagger文档
@MapperScan("com.yang.mapper")  //扫描mapper
public class MyBlogApplication {
    public static void main(String[] args) {
        SpringApplication.run(MyBlogApplication.class,args);
    }
}
