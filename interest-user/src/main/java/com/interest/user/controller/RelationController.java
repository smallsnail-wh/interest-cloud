package com.interest.user.controller;

import com.interest.common.model.ResponseWrapper;
import com.interest.user.model.entity.RelationEntity;
import com.interest.user.service.RelationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class RelationController {

    private Logger log = LoggerFactory.getLogger(RelationController.class);

    @Autowired
    private RelationService relationService;

    /**
     * 通过userId得到关系List
     *
     * @param userId
     * @return
     */
    @GetMapping("/relations/{userId}")
    public ResponseWrapper<List<RelationEntity>> getRelationByUserId(@PathVariable int userId) {
        log.debug("The method is ending");
        return new ResponseWrapper<>(relationService.getRelationByUserId(userId));
    }

    /**
     * 批量插入关系数据
     *
     * @param relationList
     * @return
     */
    @PostMapping("/relations")
    public ResponseWrapper<List<RelationEntity>> insertRelations(@RequestBody() List<RelationEntity> relationList) {
        relationService.insertRelations(relationList);
        log.debug("The method is ending");
        return new ResponseWrapper<>(relationList);
    }
}
