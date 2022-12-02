import com.yang.mapper.UserMapper;
import com.yang.pojo.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
    /**
     * 查询数据
     */
    @Test
    public void test01() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserMapper mapperImpl = context.getBean("userMapperImpl", UserMapper.class);
        for (User user : mapperImpl.selectUser()) {
            System.out.println(user);
        }
    }

    /**
     * 添加记录
     */
    @Test
    public void insterUser() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserMapper mapperImpl = context.getBean("userMapperImpl", UserMapper.class);
        int i = mapperImpl.insterUser(new User(4, "琪琪", "12369"));
        System.out.println("添加" + i + "一条记录！");
    }

    /**
     * 删除数据
     */
    @Test
    public void deleteUser(){
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
        UserMapper mapperImpl = context.getBean("userMapperImpl", UserMapper.class);
        int i = mapperImpl.deleteUser(4);
        System.out.println("删除" + i + "一条记录！");
    }

    /**
     * 修改数据
     */
    @Test
    public void updateUser(){
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
        UserMapper mapperImpl = context.getBean("userMapperImpl", UserMapper.class);
        int i = mapperImpl.updateUser(new User(6, "盈盈", "132231"));
        System.out.println("修改" + i + "一条记录！");

    }
}
