package com.interest.message.dao;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MsgRecordsDao {

    int getUnreadMsgCount(Integer userid);

}
