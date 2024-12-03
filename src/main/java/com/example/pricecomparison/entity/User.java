package com.example.pricecomparison.entity;


import lombok.Data;

//使用lombok自动生成getter和setter以及ToString方法
@Data
public class User {
    private Integer userId;

    private String username;

    private String password;

    private String email;

    private String createTime;

    private String updateTime;


}
