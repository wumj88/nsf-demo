package com.netease.cloud.consumer.service.impl;


import com.netease.cloud.consumer.service.IProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service()
public class ProviderServiceImpl implements IProviderService {

    @Autowired
    RestTemplate restTemplate;

    @Override
    public String hello() {
        final String uri = "http://nsf-spring-provider/users";
        String res = restTemplate.getForObject(uri,String.class);
        return "provider result: " + res;
    }
}
