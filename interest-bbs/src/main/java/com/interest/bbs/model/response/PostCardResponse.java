package com.interest.bbs.model.response;

import com.interest.bbs.model.entity.PostCardEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class PostCardResponse extends PostCardEntity {

    private String headimg;

    private String githuburl;

    private String username;

    private Integer replyCount;

}
