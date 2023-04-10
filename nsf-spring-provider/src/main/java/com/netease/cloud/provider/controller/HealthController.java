package com.netease.cloud.provider.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HealthController {

    @GetMapping("/health")
    @ResponseBody
    public String health() {
        return "hi, I am good!";
    }

}
