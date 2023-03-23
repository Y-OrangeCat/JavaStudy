package com.yang.job;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @Description: 定时任务  (SpringBoot 中的 @Scheduled 注解为定时任务提供了一种很简单的实现，
 * 只需要在注解中加上一些属性，例如 fixedRate、fixedDelay、cron（最常用）等等，
 * 并且在启动类上面加上 @EnableScheduling 注解，就可以启动一个定时任务了。
 * 基于注解@Scheduled默认为单线程，开启多个任务时，任务的执行时机会受上一个任务执行时间的影响。)
 * @Author: Mr.Yang
 * @Date: 2023/2/17 0:23
 * @Version: 1.0
 */
//@Component
public class TestJob {
    @Scheduled(cron = "0/5 * * * * ?")
    public void testJob() {
        System.out.println("执行了定时任务");
    }
}
