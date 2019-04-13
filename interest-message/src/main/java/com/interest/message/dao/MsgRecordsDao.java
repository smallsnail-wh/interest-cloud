package com.interest.message.dao;

import com.interest.common.model.Request.MsgRecodeRequest;
import com.interest.message.model.entity.MsgRecordEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface MsgRecordsDao {

    int getUnreadMsgCount(@Param("userId") Integer userId);

    void addMsg(MsgRecordEntity msgRecordEntity);
}
