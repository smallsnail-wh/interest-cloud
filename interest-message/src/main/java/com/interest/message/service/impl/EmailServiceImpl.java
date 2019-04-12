package com.interest.message.service.impl;

import com.interest.common.utils.DateUtil;
import com.interest.message.dao.EmailDao;
import com.interest.message.model.entity.EmailEntity;
import com.interest.message.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {

    @Autowired
    private EmailDao emailDao;

    @Override
    public void insertEntity(EmailEntity emailEntity) {
        emailEntity.setCreatetime(DateUtil.currentTimestamp());
        emailDao.insertEntity(emailEntity);
    }

}
