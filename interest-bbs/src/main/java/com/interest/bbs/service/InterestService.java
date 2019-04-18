package com.interest.bbs.service;

import com.interest.bbs.model.response.BannerVO;
import com.interest.bbs.model.response.InterestNoContentVO;
import com.interest.bbs.model.response.InterestOnlyTitleVO;
import com.interest.bbs.model.response.InterestVO;

import java.util.List;

public interface InterestService {

    List<BannerVO> getBanners();

    List<InterestNoContentVO> getInterest(String title);

    InterestVO getInterestById(int id);

    List<InterestOnlyTitleVO> getInterestsTitles();
}
