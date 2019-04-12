package com.interest.message.model.response;

import com.interest.message.model.entity.MsgRecordEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class MsgRecordResponse extends MsgRecordEntity {

    private Integer replyUserid;

    private String replyUserHeadimg;

    private String replyUsername;

    private String replyContent;

    private String title;

    private Integer toId;

}
