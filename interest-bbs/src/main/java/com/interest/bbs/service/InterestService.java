package com.interest.bbs.service;

import com.interest.bbs.model.entity.InterestEntity;
import com.interest.bbs.model.response.BannerResponse;
import com.interest.bbs.model.response.InterestResponse;
import com.interest.bbs.model.response.InterestVO;

import java.util.List;

public interface InterestService {

    List<BannerResponse> getBanners();

    List<InterestResponse> getInterest(String title);

    InterestVO getInterestById(int id);
}
