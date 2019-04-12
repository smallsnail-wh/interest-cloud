package com.interest.message.service.impl;

import com.interest.message.dao.MsgRecordsDao;
import com.interest.message.service.MsgRecordsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MsgRecordsServiceImpl implements MsgRecordsService {

    @Autowired
    private MsgRecordsDao msgRecordsDao;

    @Override
    public int getUnreadMsgCount(Integer userid) {
        return msgRecordsDao.getUnreadMsgCount(userid);
    }

}
