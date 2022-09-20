import com.itheima.reggie.ReggieApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@ContextConfiguration(classes = ReggieApplication.class)
@SpringBootTest
@RunWith(SpringRunner.class)
public class SpringDateRedisTest {

    @Autowired
    private RedisTemplate redisTemplate;

    /*
    操作String类型数据
     */
    @Test
    public void testString(){
        redisTemplate.opsForValue().set("city","beijing");

        String value = (String) redisTemplate.opsForValue().get("city");
        System.out.println(value);

        redisTemplate.opsForValue().set("city1","guangzhou",10L, TimeUnit.SECONDS);
    }

    /*
    操作hash类型数据
     */
    @Test
    public void testHash(){
        HashOperations hashOperations = redisTemplate.opsForHash();

        hashOperations.put("002","name","xiaoming");
        hashOperations.put("002","age","20");
        hashOperations.put("002","address","beijing");

        String name = (String) hashOperations.get("002", "name");
        System.out.println(name);

        //获得所有字段
        Set keys = hashOperations.keys("002");
        for(Object key : keys){
            System.out.println(key);
        }

        //获得所有值
        List values = hashOperations.values("002");
        for(Object value : values){
            System.out.println(value);
        }
    }
}
