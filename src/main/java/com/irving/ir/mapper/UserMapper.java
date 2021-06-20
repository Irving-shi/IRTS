package com.irving.ir.mapper;

import com.irving.ir.bean.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

/**
 * @author irving
 * @date 2021/6/19
 */
public interface UserMapper {

    @Insert("insert into user(username,phone,password) values(#{username},#{phone},#{password})")
    int register(User user);

    @Select("select*from user where username=#{username}")
    User login(String username);
}
