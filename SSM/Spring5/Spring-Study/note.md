## 常用依赖

### Spring aop包导入：

```xml
<dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-webmvc</artifactId>
    <version>5.2.0.RELEASE</version>
</dependency>
```

### 依赖注入：

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
https://www.springframework.org/schema/beans/spring-beans.xsd
http://www.springframework.org/schema/context
https://www.springframework.org/schema/context/spring-context.xsd">

    <!--开启注解的支持-->
    <context:annotation-config/>

</beans>
```

## 注解说明

- @Autowired: 自动装配通过类型。名字 如果Autowired不能唯一自动装配 上属性，则需要通过@Qualifier(value = "cat11")
- @Nullable:字段标记了这个注解，说明这个字段可以为nu11;
- @Resource: 自动装配通过名字。 类型


- @Component: 组件，放在类上，说明这个类被Spring管理了，就是bean! //等价于 < bean id="user" class="com.yang.pojo.User"/>
- @Value("XXX"): //相当于 < property name="name" value="范俊峰"/>