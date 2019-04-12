package com.interest.user.service.impl;

import com.interest.user.dao.RoleDao;
import com.interest.user.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao roleDao;

}
