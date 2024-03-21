package com.my.avocation.config;

import com.my.avocation.interceptor.JWTInterceptors;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        List<String> list =  new ArrayList<>();
        list.add("/login");
        list.add("/dologin");
        list.add("/loginx");
        registry.addInterceptor(new JWTInterceptors())
                .addPathPatterns("/*")
                .excludePathPatterns(list);
    }
}
