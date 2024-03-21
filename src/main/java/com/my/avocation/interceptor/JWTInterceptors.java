package com.my.avocation.interceptor;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.my.avocation.utils.JWTUtils;
import io.jsonwebtoken.ExpiredJwtException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import java.security.SignatureException;

public class JWTInterceptors implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("token");
        System.out.println("进入拦截器");
        System.out.println(request.getRequestURL());
        System.out.println(request.getRequestURI());

        try {
            JWTUtils.parseJwt(token);
            return true;
        }catch (ExpiredJwtException e){
            //token过期
            response.getWriter().write("token过期");

        }catch(Exception  e){
            e.printStackTrace();
        }
        return false;


    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
