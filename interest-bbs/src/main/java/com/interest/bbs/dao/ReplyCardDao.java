package com.interest.bbs.dao;

import com.interest.bbs.model.entity.ReplyCardEntity;
import com.interest.bbs.model.response.ReplyCardVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ReplyCardDao {

    Integer replyCardCountByPostId(@Param("postCardId") int id);

    List<ReplyCardVO> replyCardList(@Param("postCardId") int postCardId, @Param("pageSize") int pageSize,
                                    @Param("start") int start);

    Integer replyCardSize(@Param("postCardId") int postCardId, @Param("pageSize") int pageSize,
                          @Param("start") int start);

    void insertEntity(ReplyCardEntity replyCardEntity);
}
