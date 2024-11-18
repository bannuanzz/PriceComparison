package com.example.pricecomparison.service.impl;

//import com.example.pricecomparison.utils.BCryptUtil;

import com.example.pricecomparison.entity.User;
import com.example.pricecomparison.mapper.UserMapper;
import com.example.pricecomparison.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public void Register(String username, String password, String email) {
        //密码加密处理
//        String encryptedPassword = BCryptUtil.encrypt(password);
        userMapper.add(username, password, email);


    }

    @Override
    public User IsValidUsername(String username) {
        if (username.length() < 6) {
            return null;
        }
        return userMapper.findByUsername(username);
    }

    @Override
    public boolean IsValidPassword(String password) {
        return password.length() < 6;
    }

    @Override
    public boolean IsValidEmail(String email) {
        if (email == null || email.isEmpty()) {
            return false; // 空值或空字符串不合法
        }
        // 定义正则表达式
        String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        // 验证输入的 email 是否匹配正则表达式
        if (email.matches(emailRegex)) {
            return false;
        }
        return userMapper.findByEmail(email);
    }


}
