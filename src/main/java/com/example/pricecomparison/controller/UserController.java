package com.example.pricecomparison.controller;

import com.example.pricecomparison.entity.User;
import com.example.pricecomparison.entity.Result;
import com.example.pricecomparison.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public Result Register(String username, String password, String email) {

        //TODO:用switch判断下面传入的四个参数是否合法。
        User u = userService.IsValidUsername(username);
        if (u != null) {
            return Result.error(1, "username is invalid");
        } else if (userService.IsValidPassword(password)) {
            return Result.error(2, "password is invalid");

        } else if (userService.IsValidEmail(email)) {
            return Result.error(3, "email is invalid");
        } else {
            userService.Register(username, password, email);
            return Result.success();
        }

    }


}
