package com.interest.message.controller;

import com.interest.common.model.ResponseWrapper;
import com.interest.common.utils.SecurityAuthenUtil;
import com.interest.message.service.MsgRecordsService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MsgRecordsController {

    @Autowired
    private MsgRecordsService msgRecordsService;

    @ApiOperation("获取当前用户未读消息数量")
    @GetMapping("/msgrecords/unreadnum")
    public ResponseWrapper<Integer> getUnreadMsgCount() {
        return new ResponseWrapper<>(msgRecordsService.getUnreadMsgCount(SecurityAuthenUtil.getId()));
    }

}
