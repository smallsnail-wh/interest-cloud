package com.interest.bbs.service;

import com.interest.bbs.model.request.PostCardRequest;
import com.interest.bbs.model.response.PostCardInfoVO;
import com.interest.bbs.model.response.PostCardVO;

import java.util.List;

public interface PostCardService {

    List<PostCardVO> postcardList(int interestId, int pageSize, int start);

    Integer postcardSize(int interestId, int pageSize, int start);

    void insertEntity(PostCardRequest postCardRequest);

    PostCardInfoVO getPostcard(int id);

    PostCardInfoVO getPostcardNoUserInfo(int id);

    void updateReplyTime(Integer postCardId, String createTime);
}
