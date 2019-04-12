package com.interest.message.controller;

import com.interest.common.model.ResponseWrapper;
import com.interest.common.utils.SecurityAuthenUtil;
import com.interest.message.model.entity.EmailEntity;
import com.interest.message.service.EmailService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailController {

    @Autowired
    private EmailService emailService;

    @ApiOperation("发送email")
    @PostMapping("/email")
    public ResponseWrapper<EmailEntity> insertEntity(@RequestBody EmailEntity emailEntity) {
        int userId = SecurityAuthenUtil.getId();
        emailEntity.setUserid(userId);
        emailService.insertEntity(emailEntity);
        return new ResponseWrapper<>(emailEntity);
    }

}
