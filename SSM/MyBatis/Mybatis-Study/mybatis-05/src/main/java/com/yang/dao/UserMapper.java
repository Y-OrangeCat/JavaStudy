package com.yang.dao;

import com.yang.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

/**
 * 接口
 * @author Mr.Yang
 */
public interface UserMapper {
    @Select("select * from user;")
    List<User> getUser();

    @Select("select * from user where id=#{id};")
    User getUserById(@Param("id") int id);
    
    @Insert("insert into user (id,name,pwd ) values (#{id},#{name},#{password});")
    int addUser(User user);

    @Update("update user set pwd =#{password} where id=#{id} ;")
    int updateUser(@Param("id") int id,@Param("password") String password);

    @Delete("delete from user where id=#{id}")
    int deleteUser(int id);

}


