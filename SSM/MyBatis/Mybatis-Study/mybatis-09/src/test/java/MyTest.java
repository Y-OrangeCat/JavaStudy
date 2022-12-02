import com.yang.dao.UserMapper;
import com.yang.pojo.User;
import com.yang.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class MyTest {
    /**
     * 一级缓存也叫本地缓存：SqlSession
     * 与数据库同一次会话期间查询到的数据会放在本地缓存中。
     * 以后如果需要获取相同的数据，直接从缓存中拿，没必须再去查询数据库；
     */
    @Test
    public void queryUserId() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.queryUserId(1);
        System.out.println(user);
        System.out.println("===================================");
        User user2 = mapper.queryUserId(1);
        System.out.println(user2);
        System.out.println(user == user2);

        sqlSession.close();
    }

    /**
     * 二级缓存
     */
    @Test
    public void queryUserId2() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        SqlSession sqlSession2=MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.queryUserId(1);
        System.out.println(user);
        System.out.println("===================================");

        UserMapper mapper2 = sqlSession.getMapper(UserMapper.class);
        User user2 = mapper2.queryUserId(1);
        System.out.println(user2);
        System.out.println(user == user2);

        sqlSession.close();
        sqlSession2.close();
    }

    /**
     * 缓存失效
     * 增删改操作，可能会改变原来的数据，所以必定会刷新缓存！
     */
    @Test
    public void updateUser() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.queryUserId(1);
        System.out.println(user);

        mapper.updatetUser(new User(6, "朵朵", "1234567"));

        System.out.println("===================================");
        User user2 = mapper.queryUserId(1);
        System.out.println(user2);
        System.out.println(user == user2);

        sqlSession.close();
    }
}
