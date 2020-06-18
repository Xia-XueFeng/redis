package com.xxf.redis;

import com.xxf.redis.entity.User;
import com.xxf.redis.service.JedisServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Author:xuexia
 * @Date:2020/5/19
 * @Description:
 */
@SpringBootTest
public class JedisUtilsTest {
    @Autowired
    private JedisServiceImpl jedisService;

    @Test
    public void t1() {
        String val = jedisService.getString("name1");
        String val2= jedisService.getString("age");
        String val3= jedisService.getString("name");
        System.out.println(val+ val2+val3);
    }
    @Test
    public void test() {
        User user = jedisService.selectBy("2");
        System.out.println(user);
    }
}
