package com.interest.blog.dao;

import com.interest.blog.model.entity.ArticleCommentEntity;
import com.interest.blog.model.response.ArticleCommentVO;
import com.interest.blog.model.response.ArticleReplyCommentVO;
import com.interest.common.model.PageWrapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ArticleCommentDao {

    void insertEntity(ArticleCommentEntity articleCommentEntity);

    List<ArticleCommentVO> getArticleCommentByArticleId(@Param("articleId") int articleId, @Param("pageWrapper") PageWrapper pageWrapper);

    List<ArticleReplyCommentVO> getChildCommentsById(@Param("parentId") int parentId);

    int getArticleCommentSizeByArticleId(@Param("articleId") int articleId);
}
