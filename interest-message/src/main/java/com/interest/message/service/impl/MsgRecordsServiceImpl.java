package com.interest.message.service.impl;

import com.interest.common.model.Request.MsgRecodeRequest;
import com.interest.message.dao.MsgRecordsDao;
import com.interest.message.model.entity.MsgRecordEntity;
import com.interest.message.service.MsgRecordsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MsgRecordsServiceImpl implements MsgRecordsService {

    @Autowired
    private MsgRecordsDao msgRecordsDao;

    @Autowired
    private ThreadPoolTaskExecutor threadPoolTaskExecutor;

    @Override
    public int getUnreadMsgCount(Integer userId) {
        return msgRecordsDao.getUnreadMsgCount(userId);
    }

    @Override
    public void insertMessage(MsgRecodeRequest msgRecodeRequest) {
        threadPoolTaskExecutor.execute(()->{
            MsgRecordEntity msgRecordEntity = new MsgRecordEntity();
            BeanUtils.copyProperties(msgRecodeRequest,msgRecordEntity);
            log.info("insert | msg_records | data : {}", msgRecordEntity.toString());
            msgRecordsDao.addMsg(msgRecordEntity);
        });
    }

}
