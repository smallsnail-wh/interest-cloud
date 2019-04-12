package com.interest.bbs.service;

import com.interest.bbs.model.entity.PostCardEntity;
import com.interest.bbs.model.response.PostCardResponse;

import java.util.List;

public interface PostCardService {

    List<PostCardResponse> postcardList(String interestid, int pageSize, int start);

    Integer postcardSize(String interestid, int pageSize, int start);

    void insertEntity(PostCardEntity postCardEntity);

    PostCardResponse getPostcard(int id);

    void deletePostcards(List<String> groupId);

}
