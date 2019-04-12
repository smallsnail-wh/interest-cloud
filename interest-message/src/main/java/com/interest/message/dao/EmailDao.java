package com.interest.message.dao;

import com.interest.message.model.entity.EmailEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EmailDao {

    void insertEntity(EmailEntity emailEntity);

}
