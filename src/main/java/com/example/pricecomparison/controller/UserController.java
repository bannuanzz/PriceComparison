package com.example.pricecomparison.controller;

import com.example.pricecomparison.entity.User;
import com.example.pricecomparison.entity.Result;
import com.example.pricecomparison.service.UserService;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@Validated
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public Result Register(
            @Pattern(regexp = "^[a-zA-Z0-9_]{6,}$", message = "用户名必须至少6个字节，并且只能包含字母、数字和下划线") String username,
            @Pattern(regexp = "^(?=.{6,}).*$", message = "密码必须至少6个字节") String password,
            @Email(message = "邮箱格式不正确") String email) {

        User u = userService.findByUsername(username);
        if (u != null) {
            userService.Register(username, password, email);
            return Result.success();
        }
        return Result.error(1, "注册失败");
    }


}
