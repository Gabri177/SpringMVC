package com.yugao.service.impl;

import com.yugao.controller.Code;
import com.yugao.domain.UserInfo;
import com.yugao.exception.BusinissException;
import com.yugao.exception.SystemException;
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
        if (id == 1)
            throw new BusinissException("id 不能为1", Code.BUSINESS_ERR);
        //模拟系统异常，将可能出现的异常进行包装，转换成自定义异常
        try{
            int i = 1/0;
        }catch (Exception e){
            throw new SystemException("服务器访问超时，请重试!", e, Code.SYSTEM_TIMEOUT_ERR);
        }
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
