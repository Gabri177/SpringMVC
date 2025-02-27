package com.yugao.mapper;


import com.yugao.domain.User;
import org.apache.ibatis.annotations.Insert;

public interface UserMapper {

    @Insert("insert into `user`(username password) values (#{username}, SHA1(#{password}))")
    public void save(User user);
}
