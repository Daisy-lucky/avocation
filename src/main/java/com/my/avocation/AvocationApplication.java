package com.my.avocation;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
//可选，指定实体类的位置，不写则扫描全目录
@EnableJpaRepositories(basePackages = {"com.my.avocation.utils"})
//可选，同上扫描repository
@EntityScan(basePackages = "com.my.avocation.entity")
//可选，开启auditing，自动赋值，如创建时间、最后修改时间
public class AvocationApplication {

    public static void main(String[] args) {
        SpringApplication.run(AvocationApplication.class, args);
    }

}
