package com.yang;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Description: 博客后台项目启动类
 * @Author: Mr.Yang
 * @Date: 2023/2/20 0:10
 * @Version: 1.0
 */
@SpringBootApplication
@MapperScan("com.yang.mapper")
public class BlogAdminApplication {
    public static void main(String[] args) {
        SpringApplication.run(BlogAdminApplication.class, args);
    }
}
