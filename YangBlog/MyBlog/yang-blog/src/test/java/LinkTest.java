import com.yang.domain.entity.Link;
import com.yang.mapper.LinkMapper;
import com.yang.service.LinkService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @Description: Link测试类
 * @Author: Mr.Yang
 * @Date: 2022/12/7 20:48
 * @Version: 1.0
 */
@SpringBootTest
public class LinkTest {
    @Autowired
    private LinkMapper linkMapper;

    @Test
    public void test1(){
        List<Link> links = linkMapper.selectList(null);
        links.forEach(System.out::println);
    }
}
