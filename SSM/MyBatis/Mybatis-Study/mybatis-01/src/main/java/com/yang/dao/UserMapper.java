package com.yang.dao;

import com.yang.pojo.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface UserMapper {

    List<User> getUserList();

    List<User> getUserLike(String value);

    User getUserId(int id);

    int addUser(User user);

    int addUser2(Map<String, Object> map);

    int updateUser(User user);

    int deleteUser(int id);
}
