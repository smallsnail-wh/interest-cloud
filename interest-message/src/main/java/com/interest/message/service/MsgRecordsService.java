package com.interest.message.service;

import com.interest.common.model.Request.MsgRecodeRequest;

public interface MsgRecordsService {

    /**
     * 查询未读消息条数
     * @param userid
     * @return
     */
    int getUnreadMsgCount(Integer userid);

    void insertMessage(MsgRecodeRequest msgRecodeRequest);
}
