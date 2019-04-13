package com.interest.bbs.service;

import com.interest.bbs.model.request.ReplyCardRequest;
import com.interest.bbs.model.response.ReplyCardVO;

import java.util.List;

public interface ReplyCardService {


    List<ReplyCardVO> replyCardList(int postCardId, int pageSize, int start);

    Integer replyCardSize(int postCardId, int pageSize, int start);

    void insertEntity(ReplyCardRequest replyCardRequest);
}
