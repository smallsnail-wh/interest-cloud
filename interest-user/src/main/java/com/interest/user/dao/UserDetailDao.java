package com.interest.user.dao;

import com.interest.user.entity.UserDetailEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDetailDao {

    void insert(UserDetailEntity userDetailEntity);

}
