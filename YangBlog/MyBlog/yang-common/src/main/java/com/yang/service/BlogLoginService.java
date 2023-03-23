package com.yang.service;

import com.yang.domain.ResponseResult;
import com.yang.domain.entity.User;

/**
 * 用户表(User)表服务接口
 * @author makejava
 * @since 2022-12-08 20:19:46
 */
public interface BlogLoginService{

    /**
     * 用户登录
     * @param user
     * @return
     */
    ResponseResult login(User user);

    /**
     * 用户注销
     * @return
     */
    ResponseResult logout();
}

