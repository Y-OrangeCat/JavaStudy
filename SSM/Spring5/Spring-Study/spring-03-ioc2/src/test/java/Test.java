import com.yang.pojo.User;
import com.yang.pojo.UserT;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
        //Spring容器
        ApplicationContext context=new ClassPathXmlApplicationContext("ApplicationContext.xml");
        User user = (User) context.getBean("sagaf");
//        User user2 = (User) context.getBean("user");
//        System.out.println(user==user2);
        UserT userT= (UserT) context.getBean("u2");

        user.show();
        userT.show();
    }
}
