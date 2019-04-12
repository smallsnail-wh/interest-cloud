package com.interest.bbs.service.impl;

import com.interest.bbs.dao.ReplyCardDao;
import com.interest.bbs.service.ReplyCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReplyCardServiceImpl implements ReplyCardService {

    @Autowired
    private ReplyCardDao replyCardDao;
}
