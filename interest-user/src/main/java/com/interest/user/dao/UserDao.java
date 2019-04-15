package com.interest.user.dao;

import com.interest.common.model.response.UserHeadInfoVO;
import com.interest.user.model.response.UserBaseInfoVO;
import com.interest.user.model.response.UserInfoVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Set;

@Mapper
public interface UserDao {

    UserBaseInfoVO getUserBaseInfoById(@Param("id") int userId);

    List<UserHeadInfoVO> getUsersHeadInfoByIds(@Param("ids") Set<Integer> ids);

    UserHeadInfoVO getUsersHeadInfoById(@Param("id") Integer id);

    UserInfoVO getUserInfoById(@Param("userId") int userId);
}
