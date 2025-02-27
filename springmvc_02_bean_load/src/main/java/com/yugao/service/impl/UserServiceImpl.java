package com.yugao.service.impl;

import com.yugao.domain.User;
import com.yugao.mapper.UserMapper;
import com.yugao.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
//    @Autowired
//    private UserMapper userMapper;


    @Override
    public void saveUser(User user) {
        System.out.println("user service save user method was called ...");
//        userMapper.save(user);
    }
}
