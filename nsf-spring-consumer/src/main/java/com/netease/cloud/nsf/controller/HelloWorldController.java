package com.netease.cloud.consumer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.netease.cloud.consumer.service.IProviderService;
import org.springframework.beans.factory.annotation.Autowired;

@Controller
public class HelloWorldController {

    @Autowired
    IProviderService providerService;

    @GetMapping("/hello")
    @ResponseBody
    public String hello() {
        return providerService.hello();
    }

}
