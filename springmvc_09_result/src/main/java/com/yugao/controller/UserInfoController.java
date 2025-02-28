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
    public Result getAll(){

        return new Result(userInfoService.queryAllUserInfo(), "getAll success");
    }

    @GetMapping("/id/{id}")
    public Result getById(@PathVariable("id") Integer id){

        return new Result(userInfoService.queryUserInfoById(id), "getById success");
    }

    @GetMapping("/name/{name}")
    public Result getByName(@PathVariable("name") String name){
        name = "%" + name + "%";
        return new Result(userInfoService.queryUserInfoByName(name), "getByName success");
    }

    @PostMapping
    public Result saveUserInfo(@RequestBody UserInfo userInfo){
        if (userInfoService.saveUserInfo(userInfo))
            return new Result("save success");
        else
            return new Result(Code.SAVE_ERR, "save failed");
    }

    @PutMapping
    public Result modifyUserInfo(@RequestBody UserInfo userInfo){
        if (userInfoService.updateUserInfo(userInfo))
            return new Result("update success");
        else
            return new Result(Code.UPDATE_ERR, "update failed");
    }

    @DeleteMapping("/{id}")
    public Result deleteUserInfo(@PathVariable("id") Integer id){
        if (userInfoService.deleteUserInfo(id))
            return new Result("delete success");
        else
            return new Result(Code.DELETE_ERR, "delete failed");
    }


}
