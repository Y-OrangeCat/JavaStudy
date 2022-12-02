package com.yang.dao;

import com.yang.pojo.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    User queryUserId(@Param("id") int id);

    int updatetUser(User user);
}
