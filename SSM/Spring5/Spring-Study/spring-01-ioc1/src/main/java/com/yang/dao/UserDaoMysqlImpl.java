package com.yang.dao;

public class UserDaoMysqlImpl implements UserDao{
    @Override
    public void getUser() {
        System.out.println("获取Mysql的用户数据。");
    }
}
