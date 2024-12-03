package com.example.pricecomparison.mapper;


import com.example.pricecomparison.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
    @Select("select * from user where username=#{username}")
    User findByUsername(String username);

    @Insert("insert into user(username,password,email,create_time,update_time)" + "values (#{username},#{password},#{email},now(),now())")
    void add(String username, String password, String email);

    @Select("select * from user where email=#{email}")
    User findByEmail(String email);
}
