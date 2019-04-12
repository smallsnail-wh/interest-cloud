package com.interest.bbs.model.entity;

import lombok.Data;

@Data
public class PostCardEntity {
    private Integer id;

    private String title;

    private String content;

    private Integer interestid;

    private String createtime;

    private String replytime;

    private Integer userid;

}
