package com.yugao.service.impl;

import com.yugao.domain.UserInfo;
import com.yugao.mapper.UserInfoMapper;
import com.yugao.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Override
    public boolean saveUserInfo(UserInfo userInfo) {
        System.out.println("UserInfoServiceImpl saveUserInfo ==> " + userInfo);
        return userInfoMapper.addUser(userInfo) > 0;
    }

    @Override
    public boolean deleteUserInfo(int id) {
        System.out.println("UserInfoServiceImpl deleteUserInfo ==> " + id);
        return userInfoMapper.deleteUser(id) > 0;
    }

    @Override
    public boolean updateUserInfo(UserInfo userInfo) {
        System.out.println("UserInfoServiceImpl updateUserInfo ==> " + userInfo);
        return userInfoMapper.updateUser(userInfo) > 0;
    }

    @Override
    public UserInfo queryUserInfoById(int id) {
        System.out.println("UserInfoServiceImpl queryUserInfoById ==> " + id);
        return userInfoMapper.queryUserById(id);
    }

    @Override
    public List<UserInfo> queryUserInfoByName(String username) {
        System.out.println("UserInfoServiceImpl queryUserInfoByName ==> " + username);
        return userInfoMapper.queryUserByName(username);
    }

    @Override
    public List<UserInfo> queryAllUserInfo() {
        System.out.println("UserInfoServiceImpl queryAllUserInfo is running ...");
        return userInfoMapper.queryAllUser();
    }
}
