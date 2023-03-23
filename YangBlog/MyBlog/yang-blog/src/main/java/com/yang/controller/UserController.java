package com.yang.controller;

import com.yang.annotation.SystemLog;
import com.yang.domain.ResponseResult;
import com.yang.domain.entity.User;
import com.yang.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Description: 用户信息实现类
 * @Author: Mr.Yang
 * @Date: 2023/1/28 23:11
 * @Version: 1.0
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 获取用户信息
     * @return
     */
    @GetMapping("/userInfo")
    @SystemLog(businessName = "获取用户信息") //定位切点
    public ResponseResult userInfo() {
        return userService.userInfo();
    }

    /**
     * 修改用户信息
     * @param user
     * @return
     */
    @PutMapping("/userInfo")
    @SystemLog(businessName = "更新用户信息")
    public ResponseResult updateUserInfo(@RequestBody User user) {
        return userService.updateUserInfo(user);
    }

    /**
     * 注册用户
     * @param user
     * @return
     */
    @PostMapping("/register")
    public ResponseResult register(@RequestBody User user){
        return userService.register(user);
    }
}
