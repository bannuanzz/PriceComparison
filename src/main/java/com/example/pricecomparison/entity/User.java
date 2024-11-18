package com.example.pricecomparison.entity;


import lombok.Data;

//使用lombok自动生成getter和setter以及ToString方法
@Data
public class User {
    private Integer userId;

    private String userName;

    private String userPassword;

    private String eMail;

    private String createTime;

    private String updateTime;


}
