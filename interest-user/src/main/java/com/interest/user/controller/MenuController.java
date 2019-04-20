package com.interest.user.controller;

import com.interest.common.model.PageResult;
import com.interest.common.model.ResponseWrapper;
import com.interest.common.utils.SecurityAuthenUtil;
import com.interest.user.model.entity.MenuEntity;
import com.interest.user.model.request.MenuRequest;
import com.interest.user.model.response.MenuIdNameVO;
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

    @ApiOperation("获取menus表数据")
    @GetMapping("/admin/menus")
    public ResponseWrapper<PageResult> menusList(int pageSize, int page, String menuId) {
        PageResult<List<MenuEntity>> pageResult = new PageResult<>();
        pageResult.setData(menuService.menusList(pageSize, page * pageSize, menuId));
        pageResult.setTotalCount(menuService.menusSize(pageSize, page * pageSize, menuId));
        return new ResponseWrapper<>(pageResult);
    }

    @ApiOperation("通过parentId得到menus列表")
    @GetMapping("/admin/menus/parentId")
    public ResponseWrapper<List<MenuEntity>> menusByParentId(int parentId) {
        return new ResponseWrapper<>(menuService.menusByParentId(parentId));
    }

    @ApiOperation("新建菜单信息")
    @PostMapping("/admin/menus/menu")
    public ResponseWrapper<String> insertMenu(@RequestBody MenuRequest menuRequest) {
        menuService.insertMenu(menuRequest);
        return new ResponseWrapper<>("success");
    }

    @ApiOperation("修改菜单信息")
    @PutMapping("/admin/menus/{id}")
    public ResponseWrapper<MenuEntity> updateMenu(@RequestBody MenuEntity menuEntity, @PathVariable int id) {
        if (menuEntity.getId() == id) {
            menuService.updateMenu(menuEntity);
        }
        return new ResponseWrapper<>(menuEntity);
    }

    @ApiOperation("删除菜单信息")
    @DeleteMapping("/admin/menus")
    public ResponseWrapper<List<String>> deleteMenus(@RequestBody List<String> groupId) {
        menuService.deleteMenus(groupId);
        return new ResponseWrapper<>(groupId);
    }

    @ApiOperation("获取二级菜单id和name")
    @GetMapping("/admin/menus/submenus")
    public ResponseWrapper<List<MenuIdNameVO>> getSubmenus() {
        return new ResponseWrapper<>(menuService.getSubmenus());
    }
}
