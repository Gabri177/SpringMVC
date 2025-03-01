package com.yugao.service;

import com.yugao.config.SpringConfig;
import com.yugao.domain.UserInfo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {SpringConfig.class})
public class UserInfoServiceTest {

    @Autowired
    private UserInfoService userInfoService;

    @Test
    public void testFindAll() {
        List<UserInfo> userInfos = userInfoService.queryAllUserInfo();
        for (UserInfo userInfo : userInfos) {
            System.out.println(userInfo);
        }
    }

    @Test
    public void testFindById() {
        UserInfo userInfo = userInfoService.queryUserInfoById(1);
        System.out.println(userInfo);
    }

    @Test
    public void testAdd() {
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername("zha11ngsan");
        userInfo.setNickname("张11三");
        System.out.println(userInfoService.saveUserInfo(userInfo) ? "添加成功" : "添加失败");
    }

    @Test
    public void testUpdate() {
        UserInfo userInfo = new UserInfo();
        userInfo.setId(1);
        userInfo.setUsername("lisi");
        userInfo.setNickname("李四");
        System.out.println(userInfoService.updateUserInfo(userInfo) ? "修改成功" : "修改失败");
    }

    @Test
    public void testDelete() {
        System.out.println(userInfoService.deleteUserInfo(1) ? "删除成功" : "删除失败");
    }
}
