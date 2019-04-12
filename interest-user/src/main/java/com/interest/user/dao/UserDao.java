package com.interest.user.dao;

import com.interest.user.model.entity.UserEntity;
import com.interest.user.model.response.UserBaseInfoVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserDao {

    UserBaseInfoVO getUserBaseInfoById(@Param("id") int userId);
}
