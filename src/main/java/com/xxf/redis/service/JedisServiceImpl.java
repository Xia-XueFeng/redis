package com.xxf.redis.service;

import com.xxf.redis.config.JedisUtils;
import com.xxf.redis.entity.User;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author:xuexia
 * @Date:2020/5/19
 * @Description:
 */
@Service
@Log
public class JedisServiceImpl {
    @Autowired
    private JedisUtils jedisUtils;

    /*
    测试String
     */
    public String getString(String key) {
        Jedis jedis = jedisUtils.getJedis();
        String val = null;
        if (!jedis.exists(key)) {
            val = "黎明的光和影";
            log.info(key + "在MYSQL数据库中进行查询的结果是：" + val);
            jedis.set(key, val);
            log.info(key + "存入Redis中的值是：" + val);
        } else {
            val = jedis.get(key);
            log.info(key + "是在Redis中查询的数据。值是：" + val);
        }
        jedisUtils.close(jedis); //释放资源
        return val;
    }

    /**
     * 测试 jedis 操作hash类型
     * * 根据用户ID查询用户信息
     * * 先判断Redis中是否存在，
     * * 如果不存在，数据库中查询。并存到Redis中
     * * 如果存在，直接查询Redis 并返回
     */
    public User selectBy(String id) {
        String key = "user:"+id; //根据规则生成相同规范的key
        User user = new User();
        Jedis jedis = jedisUtils.getJedis();
        if (!jedis.exists(key)) { //数据库中查询，并进行存
            user.setId(id);
            user.setName("RedisHash");
            user.setAge(22);
            log.info("数据库中查询的用户信息是：" + user);
            Map<String, String> map = new HashMap();
            map.put("id", user.getId());
            map.put("name", user.getName());
            map.put("age",user.getAge().toString());
            jedis.hset(key, map);
            log.info(key + "成功存入Redis:" + user);
        } else {
            Map<String, String> map = jedis.hgetAll(key);
            user.setId(map.get("id"));
            user.setName(map.get("name"));
            System.out.println("map中的age"+map.get("age"));
            user.setAge(Integer.valueOf(map.get("age")));
            log.info(key + "Redis中查询出来的是:" + map);
        }
        Map<String, String> userVal = jedis.hgetAll(key);
        System.out.println(userVal+"mapUserVal");
        jedisUtils.close(jedis);
        return user;
    }

    /*
    redis数据库存储
     */
    public String select() {
        Jedis jedis = jedisUtils.getJedis();
        return "zhangjingwen";
    }
}
