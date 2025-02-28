package com.yugao.controller;

import com.yugao.domain.UserInfo;
import com.yugao.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "http://localhost:5173")
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;

    @GetMapping
    public List<UserInfo> getAll(){
        return userInfoService.queryAllUserInfo();
    }

    @GetMapping("/id/{id}")
    public UserInfo getById(@PathVariable("id") Integer id){
        return userInfoService.queryUserInfoById(id);
    }

    @GetMapping("/name/{name}")
    public List<UserInfo> getByName(@PathVariable("name") String name){
        name = "%" + name + "%";
        return userInfoService.queryUserInfoByName(name);
    }

    @PostMapping
    public String saveUserInfo(@RequestBody UserInfo userInfo){
        userInfoService.saveUserInfo(userInfo);
        return "{'module':'user save success'}";
    }

    @PutMapping
    public String modifyUserInfo(@RequestBody UserInfo userInfo){
        userInfoService.updateUserInfo(userInfo);
        return "{'module':'user modify success'}";
    }

    @DeleteMapping("/{id}")
    public String deleteUserInfo(@PathVariable("id") Integer id){
        userInfoService.deleteUserInfo(id);
        return "{'module':'user delete success'}";
    }


}
