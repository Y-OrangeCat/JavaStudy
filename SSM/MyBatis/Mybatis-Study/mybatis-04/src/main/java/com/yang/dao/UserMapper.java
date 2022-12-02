package com.yang.dao;

import com.yang.pojo.User;
import java.util.List;
import java.util.Map;

/**
 * 接口
 * @author Mr.Yang
 */
public interface UserMapper {

    User getUserId(int id);

    List<User> getUserLimit(Map<String,Integer> map);

    List<User> getUserRowBounds();

}


