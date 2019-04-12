package com.interest.bbs.dao;

import com.interest.bbs.model.entity.InterestEntity;
import com.interest.bbs.model.response.BannerResponse;
import com.interest.bbs.model.response.InterestResponse;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface InterestDao {

    List<BannerResponse> getBanners();

    List<InterestResponse> getInterest(@Param("title") String title);

    InterestEntity getInterestById(@Param("id") int id);

}
