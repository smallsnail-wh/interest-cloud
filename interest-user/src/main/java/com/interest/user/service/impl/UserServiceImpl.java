package com.interest.user.service.impl;

import com.interest.common.feign.InterestBlogFeign;
import com.interest.common.model.response.UserHeadInfoVO;
import com.interest.user.dao.UserDao;
import com.interest.user.model.request.UserInfoRequest;
import com.interest.user.model.response.UserBaseInfoVO;
import com.interest.user.model.response.UserInfoVO;
import com.interest.user.model.response.UserVO;
import com.interest.user.service.UserDetailService;
import com.interest.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Set;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private UserDetailService userDetailService;

    @Autowired
    private InterestBlogFeign interestBlogFeign;

    @Override
    public UserBaseInfoVO getUserBaseInfoById(int userId) {
        return userDao.getUserBaseInfoById(userId);
    }

    @Override
    public List<UserHeadInfoVO> getUsersHeadInfoByIds(Set<Integer> ids) {
        if (CollectionUtils.isEmpty(ids)) {
            return null;
        }
        return userDao.getUsersHeadInfoByIds(ids);
    }

    @Override
    public UserHeadInfoVO getUsersHeadInfoById(Integer id) {
        return userDao.getUsersHeadInfoById(id);
    }

    @Override
    public UserInfoVO getUserInfoById(int userId) {
        return userDao.getUserInfoById(userId);
    }

    @Override
    public void updateUserInfoByUserId(int userId, UserInfoRequest userInfoRequest) {
        userDao.updateUserInfo(userId, userInfoRequest.getName(), userInfoRequest.getUrl(), userInfoRequest.getEmail());
        userDetailService.updateUserInfo(userId, userInfoRequest.getInfo(), userInfoRequest.getLocation(), userInfoRequest.getSkill());
    }

    @Override
    public void updateUserHeadImg(int userId, String headImg) {
        String oldHeadImg = userDao.getUserEntityById(userId).getHeadimg();
        log.info("update | user | update user head img | params: (userId: {},headImg: {})", userId, headImg);
        userDao.updateHeadImg(userId, headImg);
        interestBlogFeign.deletePicture(oldHeadImg);
    }

    @Override
    public List<UserVO> getUsersList(String name, Integer userId, Integer status, Integer type, int pageSize, int start) {
        return userDao.getUsersList(name, userId, status, type, pageSize, start);
    }

    @Override
    public Integer getUsersSize(String name, Integer userId, Integer status, Integer type, int pageSize, int start) {
        return userDao.getUsersSize(name, userId, status, type, pageSize, start);
    }

    @Override
    public void updateUsersStatus(List<String> groupId,Integer Status) {
        log.info("update | user | update user status | groupId: {}, status: {}", groupId, Status);
        userDao.updateUsersStatus(groupId, Status);
    }
}
