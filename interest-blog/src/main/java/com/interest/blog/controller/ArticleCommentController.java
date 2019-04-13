package com.interest.blog.controller;

import com.interest.blog.model.request.ArticleCommentRequest;
import com.interest.blog.service.ArticleCommentService;
import com.interest.common.model.PageResult;
import com.interest.common.model.PageWrapper;
import com.interest.common.model.ResponseWrapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(tags = "文章评论模块")
public class ArticleCommentController {

    @Autowired
    private ArticleCommentService articleCommentService;

    @ApiOperation(value = "文章评论/回复评论")
    @PostMapping("/article/comment")
    public ResponseWrapper<String> articleComment(@RequestBody ArticleCommentRequest articleCommentRequest) {

        articleCommentService.putArticleCommentService(articleCommentRequest);

        return new ResponseWrapper<>("success");
    }

    @ApiOperation("查询文章评论")
    @GetMapping("/public/article/comment")
    public ResponseWrapper<PageResult> getArticleComment(@RequestParam("articleId") int articleId,
                                                         @RequestParam("pageSize") int pageSize,
                                                         @RequestParam("page") int page) {
        PageWrapper pageWrapper = new PageWrapper(pageSize, page);
        PageResult pageResult = articleCommentService.getArticleCommentByArticleId(articleId, pageWrapper);
        return new ResponseWrapper<>(pageResult);
    }

}
