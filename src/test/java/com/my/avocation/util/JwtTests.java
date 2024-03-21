package com.my.avocation.util;

import io.jsonwebtoken.*;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.UUID;

public class JwtTests {
    private String sign = "hp0923";

    /**
     * eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.
     * eyJ1c2VybmFtZSI6ImFkbWluIiwicm9sZXMiOiJhZG1pbiIsInN1YiI6ImFkbWluPXRlc3QiLCJleHAiOjE3MTAwODM2NzAsImp0aSI6ImNlNGYwYTExLTY0NzQtNDBhNC05ZDM1LTdkNTdhNTJlOTUyNSJ9.
     * eaU0zEncVWzXku3Yep7-dTKoUsVDP1r984dhbLayi_E
     */
    @Test
    public void createJwt(){
        //创建一个JwtBuilder对象
        JwtBuilder jwtBuilder = Jwts.builder();
        String jwtToken = jwtBuilder
                //header 头部
                .setHeaderParam("typ", "JWT")
                .setHeaderParam("alg", "HS256")
                //payload 数据
                .claim("username", "admin")
                .claim("roles", "admin")
                .setSubject("admin=test")
                //token 过期时间
                .setExpiration(new Date(System.currentTimeMillis() + 10000 * 1000))
                .setId(UUID.randomUUID().toString())
                //sign签名
                //加密算法和签名
                .signWith(SignatureAlgorithm.HS256,sign)
                .compact();
        System.out.println(jwtToken);

    }

    @Test
    public void parseJwt(){
        String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1c2VybmFtZSI6ImFkbWluIiwicm9sZXMiOiJhZG1pbiIsInN1YiI6ImFkbWluPXRlc3QiLCJleHAiOjE3MTAwOTQ0OTksImp0aSI6IjBhMmNkYTY3LWU1YzItNDhlOS05NGFiLWNmYzI0ZmVlNzlkZSJ9.-LveClPDTRGIfmnbJajEC7ZgjFlI-qvlzTC48s_e8JI";
        JwtParser jwtParser = Jwts.parser();
        Jws<Claims> claimsJws = jwtParser.setSigningKey(sign).parseClaimsJws(token);
        Claims body = claimsJws.getBody();


        System.out.println(body.getId());

        System.out.println(body.getSubject());
        System.out.println(body.get("username"));
        System.out.println(body.get("roles"));
        System.out.println(body.getExpiration());
        System.out.println(body.getIssuedAt());
        System.out.println(body.getIssuer());
        System.out.println(body.getNotBefore());
    }
}
