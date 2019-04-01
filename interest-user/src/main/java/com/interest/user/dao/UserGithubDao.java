package com.interest.user.dao;

import com.interest.user.entity.UserGithubEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserGithubDao {

    void insertEntity(UserGithubEntity userGithubEntity);
}
