package com.interest.user.controller;

import com.interest.common.model.ResponseWrapper;
import com.interest.common.utils.SecurityAuthenUtil;
import com.interest.user.model.entity.UserEntity;
import com.interest.user.model.response.UserBaseInfoVO;
import com.interest.user.service.UserService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation("获取当前用户基本信息")
    @GetMapping("/public/user")
    public ResponseWrapper<UserBaseInfoVO> userGet() {
        int userId = SecurityAuthenUtil.getIdWithoutException();
        UserBaseInfoVO userBaseInfoVO = userService.getUserBaseInfoById(userId);
        log.debug("The method is ending");
        return new ResponseWrapper<>(userBaseInfoVO);
    }

}
