package com.example.pricecomparison.service;

import com.example.pricecomparison.entity.User;

public interface UserService {
    //TODO:判断传入的四个参数是否合法，尤其是邮箱的格式。

    void Register(String username, String password, String email);

    User IsValidUsername(String username);

    boolean IsValidPassword(String password);

    boolean IsValidEmail(String email);

}
