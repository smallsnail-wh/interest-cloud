package com.interest.bbs.controller;

import com.interest.bbs.model.request.PostCardRequest;
import com.interest.bbs.model.response.PostCardInfoVO;
import com.interest.bbs.model.response.PostCardVO;
import com.interest.bbs.service.PostCardService;
import com.interest.common.model.PageResult;
import com.interest.common.model.ResponseWrapper;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PostCardController {

    @Autowired
    private PostCardService postCardService;

    @ApiOperation("获取发帖")
    @GetMapping("/public/postcards")
    public ResponseWrapper<PageResult> postcardList(@RequestParam(value = "interestId", required = false) int interestId,
                                                    @RequestParam("pageSize") int pageSize, @RequestParam("page") int page) {
        PageResult<List<PostCardVO>> pageResult = new PageResult<>();
        pageResult.setData(postCardService.postcardList(interestId, pageSize, page * pageSize));
        pageResult.setTotalCount(postCardService.postcardSize(interestId, pageSize, page * pageSize));
        return new ResponseWrapper<>(pageResult);
    }

    @ApiOperation("发帖请求")
    @PostMapping("/postcards/postcard")
    public ResponseWrapper<String> insertEntity(@RequestBody PostCardRequest postCardRequest) {
        postCardService.insertEntity(postCardRequest);
        return new ResponseWrapper<>("success");
    }

    @ApiOperation("获取单个发帖")
    @GetMapping("/public/postcards/postcard")
    public ResponseWrapper<PostCardInfoVO> postcardGet(@RequestParam("id") int id) {
        return new ResponseWrapper<>(postCardService.getPostcard(id));
    }

}