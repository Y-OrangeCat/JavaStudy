import com.yang.pojo.Hello;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
        //获取Spring的上下文对象
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("beans.xml");
        //对象都在Spring中管理了，想要使用，直接从里面获取就可以了
        Hello hello= (Hello) applicationContext.getBean("hello");
        System.out.println(hello);
    }
}
