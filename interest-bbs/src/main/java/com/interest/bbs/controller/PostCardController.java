package com.interest.bbs.controller;

import com.interest.bbs.model.response.PostCardResponse;
import com.interest.bbs.service.PostCardService;
import com.interest.common.model.PageResult;
import com.interest.common.model.ResponseWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PostCardController {

    @Autowired
    private PostCardService postCardService;

    // TODO
    @GetMapping("/public/postcards")
    public ResponseWrapper<PageResult> postcardList(@RequestParam(value = "interestid", required = false) String interestid,
                                                    @RequestParam("pageSize") int pageSize, @RequestParam("page") int page) {
        PageResult<List<PostCardResponse>> pageResult = new PageResult<>();
        pageResult.setData(postCardService.postcardList(interestid, pageSize, page * pageSize));
        pageResult.setTotalCount(postCardService.postcardSize(interestid, pageSize, page * pageSize));
        return new ResponseWrapper<>(pageResult);
    }

}
