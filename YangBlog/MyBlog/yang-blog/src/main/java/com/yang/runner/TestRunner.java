package com.yang.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @Description: 启动预处理
 * @Author: Mr.Yang
 * @Date: 2023/2/16 23:59
 * @Version: 1.0
 */
@Component
public class TestRunner implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        System.out.println("程序初始化");
    }
}
