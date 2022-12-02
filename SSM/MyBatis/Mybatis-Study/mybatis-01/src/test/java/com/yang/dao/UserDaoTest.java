package com.yang.dao;

import com.yang.pojo.User;
import com.yang.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserDaoTest {
    @Test
    public void Test() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        //方式一
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = userMapper.getUserList();
        for (User user : userList) {
            System.out.println(user);
        }

        //关闭sqlSession
        sqlSession.close();
    }


    /**
     * 模糊查询
     */
    @Test
    public void getUserLike() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> userLike = mapper.getUserLike("杰");
        for (User user : userLike) {
            System.out.println(user);
        }

        sqlSession.close();
    }

    /**
     * 查询数据
     */
    @Test
    public void getUserId() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User userId = userMapper.getUserId(1);
        System.out.println(userId);
        //关闭sqlSession
        sqlSession.close();
    }

    /**
     * 添加数据
     */
    @Test
    public void addUser() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        int i = userMapper.addUser(new User(3, "露丝", "123"));
        sqlSession.commit();
        if (i > 0) {
            System.out.println("插入成功！");
        }
        sqlSession.close();
    }

    @Test
    public void addUser2() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("userid", 6);
        map.put("name", "杰瑞");
        map.put("password", "12567");
        mapper.addUser2(map);

        sqlSession.close();
    }

    /**
     * 修改数据
     */
    @Test
    public void updateUser() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        int i = userMapper.updateUser(new User(1, "杰克", "123321"));
        if (i > 0) {
            System.out.println("修改成功");
        }
        sqlSession.commit();
        sqlSession.close();

    }

    /**
     * 删除数据
     */
    @Test
    public void deleteUser() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        int i = userMapper.deleteUser(2);
        if (i > 0) {
            System.out.println("删除成功！");
        }
        sqlSession.commit();
        sqlSession.close();
    }

}
