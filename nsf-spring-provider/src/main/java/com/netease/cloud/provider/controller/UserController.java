package com.netease.cloud.provider.controller;

import com.netease.cloud.provider.model.UserBean;
import com.netease.cloud.provider.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/users")
    @ResponseBody
    public String findall() {
        List<UserBean> users = userService.findAll();
        String res = "users: ";
        for (UserBean user : users){
            res += user.getName();
        }
        return res;
    }

}
