package com.interest.user.service;


import com.interest.user.model.response.UserBaseInfoVO;

public interface UserService {

    UserBaseInfoVO getUserBaseInfoById(int userId);

}
