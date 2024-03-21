package com.my.avocation.utils;

import io.jsonwebtoken.*;

import java.util.Calendar;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

public class JWTUtils {

    private static final String sign = "hp0923";

    // 生成token
    public static String getToken(Map<String,String> map){
        Calendar instance = Calendar.getInstance();

        // 设置过期时间
        instance.add(Calendar.SECOND, 60 * 60 * 24);
        //创建JWT builder
        JwtBuilder jwtBuilder = Jwts.builder();
        String jwtToken = jwtBuilder
                //header 头部
                .setHeaderParam("typ", "JWT")
                .setHeaderParam("alg", "HS256")

                //payload 数据
                .claim("username", map.get("username"))
                .claim("roles",    map.get("roles"))
                .setSubject("admin=test")
                //token 过期时间
                .setExpiration(new Date(System.currentTimeMillis() + 10000 * 1000))
                .setId(UUID.randomUUID().toString())
                //sign签名
                //加密算法和签名
                .signWith(SignatureAlgorithm.HS256,sign)
                .compact();
        System.out.println(jwtToken);
        return jwtToken;
    }

    public static void parseJwt(String token){
        JwtParser jwtParser = Jwts.parser();
        Jws<Claims> claimsJws = jwtParser.setSigningKey(sign).parseClaimsJws(token);
        Claims body = claimsJws.getBody();

    }
}
