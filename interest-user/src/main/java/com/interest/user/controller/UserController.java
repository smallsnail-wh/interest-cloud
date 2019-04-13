package com.interest.user.controller;

import com.interest.common.model.ResponseWrapper;
import com.interest.common.model.response.UserHeadInfoVO;
import com.interest.common.utils.SecurityAuthenUtil;
import com.interest.user.model.entity.UserEntity;
import com.interest.user.model.response.UserBaseInfoVO;
import com.interest.user.service.UserService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Set;

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

    @ApiOperation("通过用户ids来获取用户的头信息")
    @PostMapping("/public/users/ids")
    public ResponseWrapper<List<UserHeadInfoVO>> getUsersHeadInfoByIds(@RequestBody Set<Integer> ids){
        return new ResponseWrapper<>(userService.getUsersHeadInfoByIds(ids));
    }

    @ApiOperation("通过用户id来获取用户的头信息")
    @GetMapping("/public/users/user/id")
    ResponseWrapper<UserHeadInfoVO> getUsersHeadInfoById(@RequestParam("userId") Integer userId){
        return new ResponseWrapper<>(userService.getUsersHeadInfoById(userId));
    }

}
