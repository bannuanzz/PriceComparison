package com.example.pricecomparison.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BCryptUtil {
    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    // 加密方法
    public static String encrypt(String rawPassword) {
        return encoder.encode(rawPassword);
    }

    // 验证密码是否匹配
    public static boolean matches(String rawPassword, String encodedPassword) {
        return encoder.matches(rawPassword, encodedPassword);
    }
}
