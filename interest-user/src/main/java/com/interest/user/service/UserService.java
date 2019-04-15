package com.interest.user.service;


import com.interest.common.model.response.UserHeadInfoVO;
import com.interest.user.model.response.UserBaseInfoVO;
import com.interest.user.model.response.UserInfoVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.security.core.parameters.P;

import java.util.List;
import java.util.Set;

public interface UserService {

    UserBaseInfoVO getUserBaseInfoById(int userId);

    List<UserHeadInfoVO> getUsersHeadInfoByIds(Set<Integer> ids);

    UserHeadInfoVO getUsersHeadInfoById(Integer id);

    UserInfoVO getUserInfoById(int userId);
}
