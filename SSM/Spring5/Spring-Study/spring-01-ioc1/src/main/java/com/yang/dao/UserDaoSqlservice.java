package com.yang.dao;

public class UserDaoSqlservice implements UserDao{
    @Override
    public void getUser() {
        System.out.println("获取Sqlservice中的用户数据。");
    }
}
