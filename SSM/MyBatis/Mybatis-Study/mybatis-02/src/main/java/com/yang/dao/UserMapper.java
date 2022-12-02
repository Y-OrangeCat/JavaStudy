package com.yang.dao;



import com.yang.pojo.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {

    /**
     *
     * @return
     */
    List<User> getUserList();

    User getUserId(int id);

    int addUser(User user);

    int updateUser(User user);

    int deleteUser(int id);
}
