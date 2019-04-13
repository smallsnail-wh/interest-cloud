package com.interest.blog.service;

import com.interest.blog.model.request.ArticleCommentRequest;
import com.interest.common.model.PageResult;
import com.interest.common.model.PageWrapper;

public interface ArticleCommentService {

    void putArticleCommentService(ArticleCommentRequest articleCommentRequest);

    PageResult getArticleCommentByArticleId(int articleId, PageWrapper pageWrapper);
}
