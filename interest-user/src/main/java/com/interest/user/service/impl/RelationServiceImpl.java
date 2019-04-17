package com.interest.user.service.impl;

import com.interest.user.dao.RelationDao;
import com.interest.user.model.entity.RelationEntity;
import com.interest.user.service.RelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RelationServiceImpl implements RelationService {

    @Autowired
    private RelationDao relationDao;

    @Override
    public List<RelationEntity> getRelationByUserId(int userId) {
        return relationDao.getRelationByUserId(userId);
    }

    @Transactional
    @Override
    public void insertRelations(List<RelationEntity> relationList) {
        relationDao.delById(relationList.get(0).getUserId());
        if (relationList.get(0).getRoleId() != null) {
            relationDao.insertRelations(relationList);
        }
    }

}
