package com.yugao.mapper;

import com.yugao.domain.UserInfo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface UserInfoMapper {

    // add user
    @Insert("insert into information_user(username, nickname) values (#{username}, #{nickname})")
    public int addUser(UserInfo userInfo);
    // delete user
    @Delete("delete from information_user where id = #{id}")
    public int deleteUser(int id);
    // update user
    @Update("update information_user set username = #{username}, nickname = #{nickname} where id = #{id}")
    public int updateUser(UserInfo userInfo);
    // query user
    @Select("select * from information_user")
    public List<UserInfo> queryAllUser();
    // query user by id
    @Select("select * from information_user where id = #{id}")
    public UserInfo queryUserById(int id);
    // query user by name
    @Select("select * from information_user where username like #{username}")
    public List<UserInfo> queryUserByName(String username);
}
