package com.interest.bbs.service.impl;

import com.interest.bbs.dao.InterestDao;
import com.interest.bbs.model.entity.InterestEntity;
import com.interest.bbs.model.response.BannerResponse;
import com.interest.bbs.model.response.InterestResponse;
import com.interest.bbs.model.response.InterestVO;
import com.interest.bbs.service.InterestService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InterestServiceImpl implements InterestService {

    @Autowired
    private InterestDao interestDao;


    @Override
    public List<BannerResponse> getBanners() {
        return interestDao.getBanners();
    }

    @Override
    public List<InterestResponse> getInterest(String title) {
        return interestDao.getInterest(title);
    }

    @Override
    public InterestVO getInterestById(int id) {

        InterestEntity interestEntity = interestDao.getInterestById(id);
        InterestVO interestVO = new InterestVO();
        BeanUtils.copyProperties(interestEntity, interestVO);
        return interestVO;

    }
}
