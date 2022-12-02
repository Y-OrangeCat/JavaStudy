package com.yang.service;

import com.yang.dao.UserDao;
import com.yang.dao.UserDaoImpl;
import com.yang.dao.UserDaoMysqlImpl;

public class UserServiceImpl implements UserService {
    //    UserDao userDao=new UserDaoImpl();
//private UserDao userDao=new UserDaoMysqlImpl();

    private UserDao userDao;
    public void setUserDao(UserDao userDao) {
    this.userDao=userDao;
    }

    @Override
    public void getUser() {
        userDao.getUser();
    }
}
