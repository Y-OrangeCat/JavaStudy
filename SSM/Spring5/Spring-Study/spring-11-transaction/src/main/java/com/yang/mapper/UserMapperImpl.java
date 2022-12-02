package com.yang.mapper;

import com.yang.pojo.User;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import java.util.List;

public class UserMapperImpl extends SqlSessionDaoSupport implements UserMapper {
    @Override
    public List<User> selectUser() {
        User user=new User(4,"朵朵","315693");

        UserMapper mapper = getSqlSession().getMapper(UserMapper.class);

        mapper.insterUser(user);
        mapper.deleteUser(4);
        return mapper.selectUser();


    }

    @Override
    public int insterUser(User user) {
        return getSqlSession().getMapper(UserMapper.class).insterUser(user);
    }

    @Override
    public int deleteUser(int id) {
        return getSqlSession().getMapper(UserMapper.class).deleteUser(id);
    }

    @Override
    public int updateUser(User user) {
        return getSqlSession().getMapper(UserMapper.class).updateUser(user);
    }
}
