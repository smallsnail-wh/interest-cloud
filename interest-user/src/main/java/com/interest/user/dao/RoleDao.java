package com.interest.user.dao;

import com.interest.user.model.response.RoleVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface RoleDao {

    List<String> getModulesById(@Param("userId") int userId);

    List<RoleVO> allRoles();
}
