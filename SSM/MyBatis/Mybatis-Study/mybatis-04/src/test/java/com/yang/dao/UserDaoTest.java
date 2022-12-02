package com.yang.dao;

import com.yang.pojo.User;
import com.yang.utils.MybatisUtils;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserDaoTest {

    static Logger logger = Logger.getLogger(UserDaoTest.class);

    /**
     * 根据id查询
     */
    @Test
    public void getUserId() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        //方式一
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.getUserId(1);
        System.out.println(user);

        //关闭sqlSession
        sqlSession.close();
    }

    /**
     * 分页查询
     */
    @Test
    public void getUserLimit(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        Map<String, Integer> map=new HashMap<String,Integer>();
        map.put("startIndex",0);
        map.put("pageSize",2);
        List<User> userLimit = mapper.getUserLimit(map);

        for (User user:userLimit){
            System.out.println(user);
        }
        //关闭sqlSession
        sqlSession.close();
    }

    /**
     * RowBounds实现分页
     */
    @Test
    public void getUserRowBounds(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        //RowBounds实现
        RowBounds rowBounds=new RowBounds(1,2);
        //通过Java代码层面实现分页
        List<User> userList = sqlSession.selectList("com.yang.dao.UserMapper.getUserRowBounds", null, rowBounds);

        for (User user : userList) {
            System.out.println(user);
        }
        sqlSession.close();
    }

    @Test
    public void log4jTest(){
        logger.info("info:进入了testLog4j");
        logger.debug("debug:进入了testLog4j");
        logger.error("error:进入了testLog4j");
    }

}
