package com.yang.controller;

import com.yang.domain.ResponseResult;
import com.yang.domain.entity.User;
import com.yang.enums.AppHttpCodeEnum;
import com.yang.exception.SystemException;
import com.yang.service.BlogLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description: 用户管理接口实现类
 * @Author: Mr.Yang
 * @Date: 2022/12/8 20:21
 * @Version: 1.0
 */
@RestController
public class BlogLoginController {
    @Autowired
    private BlogLoginService blogLoginService;

    @PostMapping("/login")     //localhost:7777/login
    public ResponseResult user(@RequestBody User user) {
        if (!StringUtils.hasText(user.getUserName())){
            //提示必须要传入用户名
            throw new SystemException(AppHttpCodeEnum.REQUIRE_USERNAME);
        }
        return blogLoginService.login(user);
    }

    @PostMapping("/logout")
    public ResponseResult logout(){
        blogLoginService.logout();
        return ResponseResult.okResult();
    }
}
