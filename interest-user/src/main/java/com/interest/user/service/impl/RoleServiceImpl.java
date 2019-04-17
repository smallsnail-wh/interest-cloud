package com.interest.user.service.impl;

import com.interest.user.dao.RoleDao;
import com.interest.user.model.response.RoleVO;
import com.interest.user.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao roleDao;

    @Override
    public List<String> getModulesById(int userId) {
        return roleDao.getModulesById(userId);
    }

    @Override
    public List<RoleVO> allRoles() {
        return roleDao.allRoles();
    }
}
