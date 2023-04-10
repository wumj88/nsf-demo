package com.netease.cloud.provider.controller;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
public class RedisTestController {

    @Resource
    private RedisTemplate redisTemplate;

    @GetMapping("/redis/send/{msg}")
    @ResponseBody
    public String redis_send(@PathVariable String msg) {
        redisTemplate.opsForValue().set("nsftest",msg);
        System.out.println("\r\nredis send message:" + msg);
        return "hi, I am good!" + msg;
    }


    @GetMapping("/redis/get")
    @ResponseBody
    public String redis_get() {
        String msg = redisTemplate.opsForValue().get("nsftest").toString();
        System.out.println("\r\nredis recive message:" + msg);
        return "hi, I am good!" + msg;
    }

}
