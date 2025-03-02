package com.yugao.service;

import com.yugao.domain.UserInfo;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface UserInfoService {

    /**
     * save user info
     * @param userInfo
     * @return
     */
    public boolean saveUserInfo(UserInfo userInfo);
    /**
     * delete user info by id
     * @param id
     * @return
     */
    public boolean deleteUserInfo(int id);
    /**
     * update user info
     * @param userInfo
     * @return
     */
    public boolean updateUserInfo(UserInfo userInfo);
    /**
     * search user info by id
     * @param id
     * @return
     */
    public UserInfo queryUserInfoById(int id);
    /**
     * search user info by name
     * @param username
     * @return
     */
    public List<UserInfo> queryUserInfoByName(String username);
    /**
     * search all user info
     * @return
     */
    public List<UserInfo> queryAllUserInfo();
}
