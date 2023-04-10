package com.netease.cloud.provider.service.impl;


import com.netease.cloud.provider.dao.UserRepository;
import com.netease.cloud.provider.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.netease.cloud.provider.model.UserBean;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    public  List<UserBean> findAll(){
        return  userRepository.findAll();
    }
}
