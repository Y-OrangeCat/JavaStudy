import com.yang.dao.UserDao;
import com.yang.dao.UserDaoImpl;
import com.yang.dao.UserDaoMysqlImpl;
import com.yang.service.UserService;
import com.yang.service.UserServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserTest {
    public static void main(String[] args) {
//        UserService userService=new UserServiceImpl();
//        userService.getUser();
//
//        UserService userService=new UserServiceImpl();
//        ((UserServiceImpl)userService).setUserDao(new UserDaoMysqlImpl());
//        userService.getUser();
//        ((UserServiceImpl) userService).setUserDao(new UserDaoImpl());
//        userService.getUser();

        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        //相当于 UserService userService =new UserServiceImpl();
        UserService userService = (UserService) context.getBean("serverImpl");
        userService.getUser();
    }
}
