package com.yang.diy;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

//方式三：使用注解的方式实现AOP
//标注这个类是一个切面
@Aspect
public class AnnotationPointCut {
    @Before("execution(* com.yang.service.UserServiceImpl.*(..))")
    public void before() {
        System.out.println("===========方法执行前============");
    }

    @After("execution(* com.yang.service.UserServiceImpl.*(..))")
    public void after() {
        System.out.println("===========方法执行后============");
    }

    //在环绕增强中，我们可以给定一个参数，代表我们要获取处理切入的点
    @Around("execution(* com.yang.service.UserServiceImpl.*(..))")
    public void arount(ProceedingJoinPoint jp) throws Throwable {
        System.out.println("环绕前");
        //获得签名
        Signature signature = jp.getSignature();
        System.out.println("签名："+signature);
        //执行方法
        Object proceed = jp.proceed();
        System.out.println("环绕后");

        System.out.println(proceed);

    }
}
