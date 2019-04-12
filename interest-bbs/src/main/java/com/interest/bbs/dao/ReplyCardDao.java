package com.interest.bbs.dao;

import com.interest.bbs.model.entity.ReplyCardEntity;
import com.interest.bbs.model.response.ReplyCardResponse;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ReplyCardDao {


    void insertEntity(ReplyCardEntity replyCardEntity);

    List<ReplyCardResponse> replycardList(@Param("postcardid") int postcardid, @Param("pageSize") int pageSize,
                                          @Param("start") int start);

    Integer replycardSize(@Param("postcardid") int postcardid, @Param("pageSize") int pageSize,
                          @Param("start") int start);

    void delReplyByPostcardid(@Param("groupId") List<String> groupId);

    Integer replyCardCountByPostId(@Param("postcardid") int id);

}
