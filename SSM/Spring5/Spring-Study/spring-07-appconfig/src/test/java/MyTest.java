import com.yang.config.UserConfig;
import com.yang.pojo.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
    @Test
    public void test1(){
        // 如果完全使用了配置类的方式去做,我们就只能通过AnnotationConfig 上下文来获取容器,通过配置类的class对象加载!
        ApplicationContext context=new AnnotationConfigApplicationContext(UserConfig.class);
        User getUser = context.getBean("getUser", User.class);
        System.out.println(getUser.getName());
    }
}
