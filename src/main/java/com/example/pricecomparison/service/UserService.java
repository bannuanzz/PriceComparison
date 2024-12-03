package com.example.pricecomparison.service;

import com.example.pricecomparison.entity.User;

public interface UserService {

    void Register(String username, String password, String email);

    User findByUsername(String username);


    //TODO:暂时没用
    User findByEmail(String email);


}
