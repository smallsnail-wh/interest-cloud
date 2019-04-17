package com.interest.user.service;

import com.interest.user.model.response.RoleVO;

import java.util.List;

public interface RoleService {

    List<String> getModulesById(int userId);

    List<RoleVO> allRoles();
}
