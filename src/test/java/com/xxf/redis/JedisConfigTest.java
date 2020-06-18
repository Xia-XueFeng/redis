package com.xxf.redis;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * @Author:xuexia
 * @Date:2020/5/19
 * @Description:
 */
@SpringBootTest
public class JedisConfigTest {
    @Autowired
    private JedisPool jedisPool;
    @Test
    public void conextLoads() {
        System.out.println(jedisPool);
        Jedis jedis = jedisPool.getResource();
        jedis.set("name1","zjw");
        String name = jedis.get("name1");
        System.out.println(name);
        jedis.close();
    }
}