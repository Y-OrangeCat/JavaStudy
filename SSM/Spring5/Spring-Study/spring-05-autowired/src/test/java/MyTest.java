import com.yang.pojo.People;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
    @Test
    public void test1(){
        ApplicationContext context=new ClassPathXmlApplicationContext("beans.xml");
        People people = context.getBean("people", People.class);
        System.out.println(people.getName());
        people.getDog().shout();
        people.getCat().shout();
    }

    @Test
    public void test2(){
        ApplicationContext context=new ClassPathXmlApplicationContext("beans2.xml");
        People people = context.getBean("people", People.class);
        System.out.println(people.getName());
        people.getDog().shout();
        people.getCat().shout();
    }
}
