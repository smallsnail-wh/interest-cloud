package com.interest.user.controller;

import com.interest.common.model.PageResult;
import com.interest.common.model.ResponseWrapper;
import com.interest.user.model.entity.RoleEntity;
import com.interest.user.model.response.RoleVO;
import com.interest.user.service.RoleService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class RoleController {

    @Autowired
    private RoleService roleService;

    @ApiOperation("得到角色全部数据")
    @GetMapping("/roles/all")
    public ResponseWrapper<List<RoleVO>> allRoles() {
        return new ResponseWrapper<>(roleService.allRoles());
    }

    //TODO
    /**
     * 获取role表数据
     *
     * @param pageSize
     * @param page
     * @return
     */
    @GetMapping("/roles")
    public ResponseWrapper<PageResult> rolesList(String loginName, int pageSize, int page) {
        PageResult pageResult = new PageResult();
//        pageResult.setData(roleService.rolesList(pageSize, page * pageSize));
//        pageResult.setTotalCount(roleService.rolesSize(pageSize, page * pageSize));
        log.debug("The method is ending");
        return new ResponseWrapper<>(pageResult);
    }

    /**
     * 新建角色信息
     *
     * @param roleEntity
     * @return
     */
    @PostMapping("/roles/role")
    public ResponseWrapper<RoleEntity> insertRole(@RequestBody RoleEntity roleEntity) {
        //roleService.insertRole(roleEntity);
        log.debug("The method is ending");
        return new ResponseWrapper<>(roleEntity);
    }

    /**
     * 更新角色信息
     *
     * @param roleEntity
     * @param id
     * @return
     */
    @PutMapping("/roles/{id}")
    public ResponseWrapper<RoleEntity> updateRole(@RequestBody RoleEntity roleEntity, @PathVariable int id) {
        if (roleEntity.getId() == id) {
            //roleService.updateRole(roleEntity);
        }
        log.debug("The method is ending");
        return new ResponseWrapper<>(roleEntity);
    }

    /**
     * 删除角色信息
     *
     * @param groupId
     * @return
     */
    @DeleteMapping("/roles")
    public ResponseWrapper<List<String>> deleteRoles(@RequestBody List<String> groupId) {
        //roleService.deleteRoles(groupId);
        return new ResponseWrapper<>(groupId);
    }
}
