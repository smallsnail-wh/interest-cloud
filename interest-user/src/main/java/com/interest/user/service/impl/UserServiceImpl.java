package com.interest.user.service.impl;

import com.interest.common.model.response.UserHeadInfoVO;
import com.interest.user.dao.UserDao;
import com.interest.user.model.response.UserBaseInfoVO;
import com.interest.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;


    @Override
    public UserBaseInfoVO getUserBaseInfoById(int userId) {
        return userDao.getUserBaseInfoById(userId);
    }

    @Override
    public List<UserHeadInfoVO> getUsersHeadInfoByIds(Set<Integer> ids) {
        if(CollectionUtils.isEmpty(ids)){
            return null;
        }
        return userDao.getUsersHeadInfoByIds(ids);
    }

    @Override
    public UserHeadInfoVO getUsersHeadInfoById(Integer id) {
        return userDao.getUsersHeadInfoById(id);
    }
}
