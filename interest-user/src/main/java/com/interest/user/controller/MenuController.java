package com.interest.user.controller;

import com.interest.common.model.PageResult;
import com.interest.common.model.ResponseWrapper;
import com.interest.common.utils.SecurityAuthenUtil;
import com.interest.user.model.entity.MenuEntity;
import com.interest.user.model.response.MenuVO;
import com.interest.user.service.MenuService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class MenuController {

    @Autowired
    private MenuService menuService;

    @ApiOperation("获取该用户的菜单权限")
    @GetMapping("/menus/page")
    public ResponseWrapper<List<MenuVO>> getMenuList() {
        return new ResponseWrapper<>(menuService.menuList(SecurityAuthenUtil.getId()));
    }

    //TODO

    /**
     * 获取menus表数据
     *
     * @param pageSize
     * @param page
     * @return
     */
    @GetMapping("/menus")
    public ResponseWrapper<PageResult> menusList(int pageSize, int page, String menuId) {
        PageResult pageResult = new PageResult();
        pageResult.setData(menuService.menusList(pageSize, page * pageSize, menuId));
        pageResult.setTotalCount(menuService.menusSize(pageSize, page * pageSize, menuId));
        log.debug("The method is ending");
        return new ResponseWrapper<>(pageResult);
    }

    /**
     * 通过parentId得到menus列表
     *
     * @param parentId
     * @return
     */
    @GetMapping("/menus/parentId")
    public ResponseWrapper<List<MenuEntity>> menusByParentId(int parentId) {
        return new ResponseWrapper<>(menuService.menusByParentId(parentId));
    }

    /**
     * 新建菜单信息
     *
     * @param menuEntity
     * @return
     */
    @PostMapping("/menus/menu")
    public ResponseWrapper<MenuEntity> insertMenu(@RequestBody MenuEntity menuEntity) {
        menuService.insertMenu(menuEntity);
        log.debug("The method is ending");
        return new ResponseWrapper<>(menuEntity);
    }

    /**
     * 修改菜单信息
     *
     * @param menuEntity
     * @param id
     * @return
     */
    @PutMapping("/menus/{id}")
    public ResponseWrapper<MenuEntity> updateMenu(@RequestBody MenuEntity menuEntity, @PathVariable int id) {
        if (menuEntity.getId() == id) {
            menuService.updateMenu(menuEntity);
        }
        log.debug("The method is ending");
        return new ResponseWrapper<>(menuEntity);
    }

    /**
     * 删除菜单信息
     *
     * @param groupId
     * @return
     */
    @DeleteMapping("/menus")
    public ResponseWrapper<List<String>> deleteMenus(@RequestBody List<String> groupId) {
        menuService.deleteMenus(groupId);
        return new ResponseWrapper<>(groupId);
    }

    /**
     * 获取二级菜单
     *
     * @return
     */
    @GetMapping("/menus/submenus")
    public ResponseWrapper<List<MenuEntity>> getSubmenus() {
        return new ResponseWrapper<>(menuService.getSubmenus());
    }
}
