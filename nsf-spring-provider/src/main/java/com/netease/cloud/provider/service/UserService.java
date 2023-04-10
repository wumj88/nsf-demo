package com.netease.cloud.provider.service;

import com.netease.cloud.provider.model.UserBean;

import java.util.List;

public interface UserService {
    public List<UserBean> findAll();
}
