package com.interest.bbs.controller;

import com.interest.bbs.model.response.BannerVO;
import com.interest.bbs.model.response.InterestNoContentVO;
import com.interest.bbs.model.response.InterestOnlyTitleVO;
import com.interest.bbs.model.response.InterestVO;
import com.interest.bbs.service.InterestService;
import com.interest.common.model.ResponseWrapper;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class InterestController {

    @Autowired
    private InterestService interestService;

    @ApiOperation("获取首页banner数据")
    @GetMapping("/public/banners")
    public ResponseWrapper<List<BannerVO>> bannersGet() {
        return new ResponseWrapper<>(interestService.getBanners());
    }

    @ApiOperation("获取首页兴趣")
    @GetMapping("/public/interests")
    public ResponseWrapper<List<InterestNoContentVO>> interestGet(@RequestParam(value = "title", required = false) String title) {
        return new ResponseWrapper<>(interestService.getInterest(title));
    }

    @ApiOperation("获取兴趣详情")
    @GetMapping("/public/interests/interest")
    public ResponseWrapper<InterestVO> interestGetById(@RequestParam(value = "id") int id) {
        return new ResponseWrapper<>(interestService.getInterestById(id));
    }

    @ApiOperation("获取兴趣ID+title")
    @GetMapping("/admin/interests/titles")
    public ResponseWrapper<List<InterestOnlyTitleVO>> getInterestsTitles() {
        return new ResponseWrapper<>(interestService.getInterestsTitles());
    }

}
