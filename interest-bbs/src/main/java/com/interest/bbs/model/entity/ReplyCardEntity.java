package com.interest.bbs.model.entity;

import lombok.Data;

@Data
public class ReplyCardEntity {
	private Integer id;

	private String content;

	private Integer postcardid;

	private String createtime;

	private Integer userid;

}
