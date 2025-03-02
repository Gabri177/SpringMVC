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
        List<UserInfo> success = userInfoService.queryAllUserInfo();

        return !success.isEmpty() ? new Result(success, "getAll success")
                : new Result(Code.GET_ERR, "getAll failed");
    }

    @GetMapping("/id/{id}")
    public Result getById(@PathVariable("id") Integer id){
        Object success = userInfoService.queryUserInfoById(id);
        return success != null ? new Result(success, "getById success")
                : new Result(Code.GET_ERR, "getById failed");
    }

    @GetMapping("/name/{name}")
    public Result getByName(@PathVariable("name") String name){
        name = "%" + name + "%";
        List<UserInfo> success = userInfoService.queryUserInfoByName(name);
        return !success.isEmpty() ? new Result(success, "getByName success")
                : new Result(Code.GET_ERR, "getByName failed");
    }

    @PostMapping
    public Result saveUserInfo(@RequestBody UserInfo userInfo) {
        boolean success = userInfoService.saveUserInfo(userInfo);
        return success ? new Result("save success")
                : new Result(Code.SAVE_ERR, "save failed");
    }

    @PutMapping
    public Result modifyUserInfo(@RequestBody UserInfo userInfo) {
        boolean success = userInfoService.updateUserInfo(userInfo);
        return success ? new Result("update success") : new Result(Code.UPDATE_ERR, "update failed");
    }

    @DeleteMapping("/{id}")
    public Result deleteUserInfo(@PathVariable("id") Integer id) {
        boolean success = userInfoService.deleteUserInfo(id);
        return success ? new Result("delete success") : new Result(Code.DELETE_ERR, "delete failed");
    }



}
