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
    public User findByUsername(String username) {
        return userMapper.findByUsername(username);

    }

    public User findByEmail(String email) {
        return userMapper.findByEmail(email);
    }


}
