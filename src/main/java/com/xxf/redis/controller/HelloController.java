package com.xxf.redis.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author:xuexia
 * @Date:2020/5/14
 * @Description:
 */
@RestController
public class HelloController {

    @RequestMapping("hello")
    public String sayHello() {
        return "Hello Spring Boot";
    }
}
