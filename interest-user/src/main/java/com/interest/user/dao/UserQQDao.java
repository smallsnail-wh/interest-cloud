package com.interest.user.dao;

import com.interest.user.entity.UserQQEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserQQDao {

    void insertEntity(UserQQEntity userQQEntity);
}
