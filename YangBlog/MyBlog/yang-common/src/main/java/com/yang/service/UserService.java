package com.yang.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yang.domain.ResponseResult;
import com.yang.domain.entity.User;

/**
 * 用户表(User)表服务接口
 * @author makejava
 * @since 2023-01-14 23:43:01
 */
public interface UserService extends IService<User> {

    /**
     * 获取用户信息
     * @return
     */
    ResponseResult userInfo();

    /**
     * 修改用户信息
     * @param user
     * @return
     */
    ResponseResult updateUserInfo(User user);

    /**
     * 注册用户
     * @param user
     * @return
     */
    ResponseResult register(User user);

    /**
     * 分页查询用户——后台
     */
    ResponseResult selectUserPage(User user, Integer pageNum, Integer pageSize);

    boolean checkUserNameUnique(String userName);

    boolean checkPhoneUnique(User user);

    boolean checkEmailUnique(User user);

    /**
     * 添加用户——后台
     * @param user
     * @return
     */
    ResponseResult addUser(User user);

    /**
     * 修改用户——后台
     * @param user
     */
    void updateUser(User user);
}

