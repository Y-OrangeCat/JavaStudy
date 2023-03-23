import com.yang.domain.entity.Tag;
import com.yang.mapper.TagMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @Description:
 * @Author: Mr.Yang
 * @Date: 2023/2/20 0:34
 * @Version: 1.0
 */
@SpringBootTest
public class TagTest {
    @Autowired
    private TagMapper tagMapper;

    @Test
    public void test01(){
        List<Tag> tagList = tagMapper.selectList(null);
        tagList.forEach(System.out::println);
    }

}
