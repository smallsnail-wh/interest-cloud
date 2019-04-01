package com.interest.user.service.impl;

import com.interest.user.dao.UserQQDao;
import com.interest.user.entity.UserQQEntity;
import com.interest.user.service.UserQQService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserQQServiceImpl implements UserQQService {

    @Autowired
    private UserQQDao userQQDao;

    @Override
    public void insertEntity(UserQQEntity userQQEntity) {
        userQQDao.insertEntity(userQQEntity);
    }
}
