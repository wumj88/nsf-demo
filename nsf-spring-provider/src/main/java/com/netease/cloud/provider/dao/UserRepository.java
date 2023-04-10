package com.netease.cloud.provider.dao;

import com.netease.cloud.provider.model.UserBean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserBean,Long> {

}