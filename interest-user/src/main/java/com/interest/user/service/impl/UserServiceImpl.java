package com.interest.user.service.impl;

import com.interest.user.dao.UserDao;
import com.interest.user.model.response.UserBaseInfoVO;
import com.interest.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;


    @Override
    public UserBaseInfoVO getUserBaseInfoById(int userId) {
        return userDao.getUserBaseInfoById(userId);
    }
}
