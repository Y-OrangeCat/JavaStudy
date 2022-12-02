import com.yang.pojo.Student;
import com.yang.pojo.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        Student student = (Student) context.getBean("student");
        System.out.println(student);

        /*
         Student{name='杨超越',
         adress=Adress{adress='江苏'},
         books=[红楼梦, 西游记, 水浒传, 三国演义],
         hobbys=[听歌, 电影, 运动],
         card={身份证=186265162669, 银行卡号=33261667962},
         games=[刺激战场, 王者峡谷, 坦克世界],
         info={学号=20210306, 性别=女, 姓名=刘亦菲}}
         */

    }

    @Test
    public void getUser() {
        ApplicationContext context = new ClassPathXmlApplicationContext("userbeans.xml");
        User user = context.getBean("user2", User.class);
        User user2 = context.getBean("user2", User.class);
        System.out.println(user);
        System.out.println(user2);
        System.out.println(user==user2);
    }

    @Test
    public void getUser2(){
        ApplicationContext context=new ClassPathXmlApplicationContext("userbeans.xml");
        User user = context.getBean("user2", User.class);
        System.out.println(user);
    }

}
