import com.yang.service.UserService;
import com.yang.service.UserServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        //动态代理，代理的是接口
        UserService userService = context.getBean("userService", UserService.class);
        userService.add();
    }

    @Test
    public void test02(){
        ApplicationContext context = new ClassPathXmlApplicationContext("diyBeans.xml");
        UserService userService = context.getBean("userService", UserService.class);
        userService.select();
    }

    @Test
    public void test03(){
        ApplicationContext context = new ClassPathXmlApplicationContext("AnnoBeans.xml");
        UserService userService = context.getBean("userService", UserService.class);
        userService.update();

    }
}
