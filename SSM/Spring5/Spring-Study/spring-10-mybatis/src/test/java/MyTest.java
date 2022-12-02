import com.yang.mapper.UserMapper;
import com.yang.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MyTest {
    /**
     * 原始方式
     * @throws IOException
     */
    @Test
    public void selectUser() throws IOException {
        String resource="mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = userMapper.selectUser();

        //遍历用户集合
        for (User user : userList) {
            System.out.println(user);
        }
    }

    /**
     * Spring-Mybatis整合方式一
     */
    @Test
    public void test01(){
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-dao.xml");
        UserMapper mapper = context.getBean("userMapperImpl", UserMapper.class);
        for (User user : mapper.selectUser()) {
            System.out.println(user);
        }
    }

    /**
     * Spring-Mybatis整合方式二
     */
    @Test
    public void test02(){
            ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
        UserMapper mapperImpl02 = context.getBean("userMapperImpl02", UserMapper.class);
        for (User user : mapperImpl02.selectUser()) {
            System.out.println(user);
        }
    }
}
