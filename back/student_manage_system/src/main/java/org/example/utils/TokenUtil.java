package org.example.utils;

import io.jsonwebtoken.*;

import java.util.Date;
import java.util.HashMap;

@SuppressWarnings("all")
public class TokenUtil {

    public static String getToken(String content) {
        JwtBuilder jwtBuilder = Jwts.builder();
        HashMap<String, Object> map = new HashMap<>();
        map.put("content", content);
        String token = jwtBuilder.setClaims(map) //通过map传值
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 30)) //设置token有效期
                .signWith(SignatureAlgorithm.HS256, "zhangzijia").compact();//设置token加密方式和密码
        return token;
    }

    public static String parseToken(String token) {
        JwtParser jwtParser = Jwts.parser(); //获取jwt解析器
        jwtParser.setSigningKey("zhangzijia");
        Jws<Claims> claimsJws = jwtParser.parseClaimsJws(token);
        Claims body = claimsJws.getBody();//获取body
        String content = body.get("content", String.class);
        System.out.println(content);
        return content;

    }
}
