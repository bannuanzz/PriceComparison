package com.example.pricecomparison.controller;

import com.example.pricecomparison.entity.User;
import com.example.pricecomparison.entity.Result;
import com.example.pricecomparison.service.UserService;
//import com.example.pricecomparison.utils.BCryptUtil;
import com.example.pricecomparison.utils.JWTUtil;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.parameters.P;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/user")
@Validated
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private JWTUtil jwtUtil;

    @PostMapping("/register")
    public Result Register(
            @Pattern(regexp = "^[a-zA-Z0-9_]{6,}$", message = "用户名必须至少6个字节，并且只能包含字母、数字和下划线") String username,
            @Pattern(regexp = "^(?=.{6,}).*$", message = "密码必须至少6个字节") String password,
            @Email(message = "邮箱格式不正确") String email) {

        User u = userService.findByUsername(username);
        System.out.println("email " + password);
        if (u == null) {
            userService.Register(username, password, email);
            return Result.success();
        }
        return Result.error(1, "注册失败");
    }

    @PostMapping("/login")
    public Result<String> Login(
            @Pattern(regexp = "^[a-zA-Z0-9_]{6,}$", message = "用户名必须至少6个字节，并且只能包含字母、数字和下划线") String username,
            @Pattern(regexp = "^(?=.{6,}).*$", message = "密码必须至少6个字节") String password,
//            @Email(message = "邮箱格式不正确") String email
            Principal principal) {


        //TODO:想实现邮箱和用户名都可以登录。
        User loginUser = userService.findByUsername(username);
        if (loginUser == null) {
            return Result.error(1, "用户名不存在");
        }
        System.out.println("loginUserPassword " + loginUser.getPassword());
        System.out.println("loginUserName " + loginUser.getUsername());
        if (password.equals(loginUser.getPassword())) {
            //之后的所有map下面都要先验证token
            String token = jwtUtil.generateToken(loginUser.getUsername());
            return Result.success(token);
        }
        return Result.error(1, "密码错误");
    }
}
