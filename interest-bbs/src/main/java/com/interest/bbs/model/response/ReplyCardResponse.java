package com.interest.bbs.model.response;

import com.interest.bbs.model.entity.ReplyCardEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class ReplyCardResponse extends ReplyCardEntity {

    private String headimg;

    private String githuburl;

    private String username;

}
