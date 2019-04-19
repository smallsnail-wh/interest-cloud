package com.interest.user.controller;

import com.interest.common.model.PageResult;
import com.interest.common.model.ResponseWrapper;
import com.interest.common.model.response.UserHeadInfoVO;
import com.interest.common.utils.SecurityAuthenUtil;
import com.interest.user.model.request.UserInfoRequest;
import com.interest.user.model.response.UserBaseInfoVO;
import com.interest.user.model.response.UserInfoVO;
import com.interest.user.model.response.UserVO;
import com.interest.user.service.UserService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public ResponseWrapper<List<UserHeadInfoVO>> getUsersHeadInfoByIds(@RequestBody Set<Integer> ids) {
        return new ResponseWrapper<>(userService.getUsersHeadInfoByIds(ids));
    }

    @ApiOperation("通过用户id来获取用户的头信息")
    @GetMapping("/public/users/user/id")
    ResponseWrapper<UserHeadInfoVO> getUsersHeadInfoById(@RequestParam("userId") Integer userId) {
        return new ResponseWrapper<>(userService.getUsersHeadInfoById(userId));
    }

    @ApiOperation("获取用户详情")
    @GetMapping("/general/users/user/info")
    public ResponseWrapper<UserInfoVO> getUserInfo() {
        int userId = SecurityAuthenUtil.getId();
        UserInfoVO userInfoResponse = userService.getUserInfoById(userId);
        return new ResponseWrapper<>(userInfoResponse);
    }

    @GetMapping("/public/users/user/info")
    @ApiOperation("通过用户id来获取用户详情")
    public ResponseWrapper<UserInfoVO> getUserInfoById(@RequestParam("userId") int userId) {
        UserInfoVO userInfoResponse = userService.getUserInfoById(userId);
        return new ResponseWrapper<>(userInfoResponse);
    }

    @ApiOperation("修改用户详情")
    @PutMapping("/general/users/user/info")
    public ResponseWrapper<String> updateUserInfo(@RequestBody UserInfoRequest userInfoRequest) {
        int userId = SecurityAuthenUtil.getId();
        userService.updateUserInfoByUserId(userId, userInfoRequest);
        return new ResponseWrapper<>("success");
    }

    @ApiOperation("更新用户头像")
    @PatchMapping("/general/users/user/headImg")
    public ResponseWrapper<String> updateUserHeadImg(@RequestParam("headImg") String headImg) {
        int userId = SecurityAuthenUtil.getId();
        userService.updateUserHeadImg(userId, headImg);
        return new ResponseWrapper<>(headImg);
    }

    @ApiOperation("获取user表数据")
    @GetMapping("/admin/users")
    public ResponseWrapper<PageResult<List<UserVO>>> getUsersList(@RequestParam(value = "name", required = false) String name,
                                                                  @RequestParam(value = "userId", required = false) Integer userId,
                                                                  @RequestParam(value = "status") Integer status,
                                                                  @RequestParam(value = "type") Integer type,
                                                                  @RequestParam("pageSize") int pageSize, @RequestParam("page") int page) {
        PageResult<List<UserVO>> pageResult = new PageResult<>();
        pageResult.setData(userService.getUsersList(name, userId, status,type, pageSize, page * pageSize));
        pageResult.setTotalCount(userService.getUsersSize(name, userId, status,type, pageSize, page * pageSize));
        log.debug("The method is ending");
        return new ResponseWrapper<>(pageResult);
    }

    @ApiOperation("删除用户")
    @DeleteMapping("/admin/users")
    public ResponseWrapper<List<String>> deleteUsers(@RequestBody List<String> groupId) {
        userService.updateUsersStatus(groupId,1);
        return new ResponseWrapper<>(groupId);
    }

    @ApiOperation("恢复用户")
    @PatchMapping("/admin/users")
    public ResponseWrapper<List<String>> recoverUsers(@RequestBody List<String> groupId) {
        userService.updateUsersStatus(groupId,0);
        return new ResponseWrapper<>(groupId);
    }
}
