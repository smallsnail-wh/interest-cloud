package com.interest.bbs.controller;

import com.interest.bbs.service.ReplyCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReplyCardController {

    @Autowired
    private ReplyCardService replyCardService;


}
