package com.my.avocation.repository;

import com.my.avocation.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    //验证登录
    User findByUnameAndPassword(String uname, String password);
}
