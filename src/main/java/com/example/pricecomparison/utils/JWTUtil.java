package com.example.pricecomparison.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JWTUtil {

    // 密钥（需要保密，建议至少 256 位）
    private static final String SECRET_KEY_STRING = "Morri7788@#$%^&*1234567890abcdefgh"; // 长度为32字节

    private static final SecretKey SECRET_KEY = Keys.hmacShaKeyFor(SECRET_KEY_STRING.getBytes(StandardCharsets.UTF_8));

    // 令牌有效期 1小时
    private static final long EXPIRATION_TIME = 1000 * 60 * 60; // 1 小时

    // 生成 JWT 令牌
    public String generateToken(String username) {
        Map<String, Object> claims = new HashMap<>();
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(SECRET_KEY, SignatureAlgorithm.HS256) // 使用安全密钥
                .compact();
    }

    // 从 JWT 令牌中提取用户名
    public String extractUsername(String token) {
        return extractClaims(token).getSubject();
    }

    // 验证 JWT 令牌
    public boolean validateToken(String token, String username) {
        String tokenUsername = extractUsername(token);
        return (tokenUsername.equals(username) && !isTokenExpired(token));
    }

    // 判断 JWT 是否过期
    public boolean isTokenExpired(String token) {
        return extractClaims(token).getExpiration().before(new Date());
    }

    // 提取所有声明
    private Claims extractClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(SECRET_KEY) // 使用新的密钥对象
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
}

