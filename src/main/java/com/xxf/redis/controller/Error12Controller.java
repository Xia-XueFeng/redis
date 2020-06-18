package com.xxf.redis.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author:xuexia
 * @Date:2020/5/14
 * @Description:
 */
@RestController
public class Error12Controller {

    @RequestMapping("/xxf/error12")
    public String sayError() {
        return "啊哦~你想找的内容离你而去了哦";
    }
}
