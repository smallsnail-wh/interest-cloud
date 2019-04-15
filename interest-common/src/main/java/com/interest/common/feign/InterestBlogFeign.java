package com.interest.common.feign;

import com.interest.common.model.ResponseWrapper;
import com.interest.common.model.response.MsgContentVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Set;

@FeignClient(name = "interest-blog")
public interface InterestBlogFeign {

    String INTEREST_USER_BASE_URL = "/interest/blog";

    @PostMapping(INTEREST_USER_BASE_URL + "/article/comments/ids")
    ResponseWrapper<List<MsgContentVO>> getMsgContentByIds(@RequestBody Set<Integer> ids);

}
