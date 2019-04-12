package com.interest.user.service.impl;

import com.interest.user.dao.UserDetailDao;
import com.interest.user.service.UserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImpl implements UserDetailService {

    @Autowired
    private UserDetailDao userDetailDao;

}
