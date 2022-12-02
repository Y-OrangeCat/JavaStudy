package com.yang.mapper;

import com.yang.pojo.User;

import java.util.List;

public interface UserMapper {

    List<User> selectUser();

    int insterUser(User user);

    int deleteUser(int id);

    int updateUser(User user);
}
