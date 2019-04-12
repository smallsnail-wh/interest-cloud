package com.interest.message.service;

public interface MsgRecordsService {

    /**
     * 查询未读消息条数
     * @param userid
     * @return
     */
    int getUnreadMsgCount(Integer userid);

}
