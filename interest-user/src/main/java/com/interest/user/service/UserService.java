package com.interest.user.service;


import com.interest.user.entity.UserEntity;

public interface UserService {

    UserEntity getUserEntityById(Integer id);

    UserEntity getUserEntityByLoginName(String id);

    UserEntity getEntityByGithubId(String login);

    void insertUser(UserEntity userEntity);

    void updateUserHeadImg(int userId, String headImg);

    UserEntity getEntityByQqid(String openid);

    void insertUserByQq(UserEntity userEntity);
}
