package com.yang.dao;

import com.yang.pojo.User;
import com.yang.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class UserDaoTest {
    @Test
    public void Test() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        //方式一
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.getUserId(1);
        System.out.println(user);

        //关闭sqlSession
        sqlSession.close();
    }


}
