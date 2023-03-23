package com.yang.controller;

import com.yang.domain.ResponseResult;
import com.yang.domain.entity.Menu;
import com.yang.domain.vo.MenuTreeVo;
import com.yang.domain.vo.MenuVo;
import com.yang.domain.vo.RoleMenuTreeSelectVo;
import com.yang.service.MenuService;
import com.yang.utils.BeanCopyUtils;
import com.yang.utils.SystemConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Description: 菜单控制层
 * @Author: Mr.Yang
 * @Date: 2023/3/6 23:23
 * @Version: 1.0
 */
@RestController
@RequestMapping("/system/menu")
public class MenuController {
    @Autowired
    private MenuService menuService;

    /**
     * 获取菜单列表——后台
     * @param menu
     * @return
     */
    @GetMapping("/list")
    public ResponseResult selectMenuList(Menu menu) {
        List<Menu> menus = menuService.selectMenuList(menu);
        List<MenuVo> menuVos = BeanCopyUtils.copyBeanList(menus, MenuVo.class);
        return ResponseResult.okResult(menuVos);
    }

    /**
     * 增加菜单
     * @param menu
     * @return
     */
    @PostMapping
    public ResponseResult addMenu(@RequestBody Menu menu){
        menuService.save(menu);
        return ResponseResult.okResult();
    }

    /**
     * 修改菜单——获取菜单详情
     * @param menuId
     * @return
     */
    @GetMapping("/{menuId}")
    public ResponseResult getMenu(@PathVariable Long menuId){
        Menu menu = menuService.getById(menuId);
        return ResponseResult.okResult(menu);
    }

    /**
     * 修改菜单
     * @param menu
     * @return
     */
    @PutMapping
    public ResponseResult updateMenu(Menu menu){
        if (menu.getId().equals(menu.getParentId())){
            return ResponseResult.errorResult(500,"修改菜单" + menu.getMenuName() + "失败，上级菜单不能选择自己");
        }
        menuService.updateById(menu);
        return ResponseResult.okResult();
    }

    /**
     * 删除菜单
     * @param menuId
     * @return
     */
    @DeleteMapping("menuId")
    public ResponseResult deleteMenu(@PathVariable Long menuId){
        //查询是否存在子菜单
        if(menuService.hasChild(menuId)){
            return ResponseResult.errorResult(500,"存在子菜单不允许删除");
        }
        menuService.removeById(menuId);
        return ResponseResult.okResult();
    }
    /**
     * 获取菜单下拉树列表——添加角色的时候
     */
    @GetMapping("/treeselect")
    public ResponseResult treeselect(){
        //复用之前的selectMenuList方法。方法需要参数，参数可以用来进行条件查询，而这个方法不需要条件，所以直接new Menu()传入
        List<Menu> menus = menuService.selectMenuList(new Menu());
        List<MenuTreeVo> menuTreeVos = SystemConverter.buildMenuSelectTree(menus);
        return ResponseResult.okResult(menuTreeVos);

    }

    /**
     * 加载对应角色菜单列表树
     */
    @GetMapping(value = "/roleMenuTreeselect/{roleId}")
    public ResponseResult roleMenuTreeSelect(@PathVariable("roleId") Long roleId){
        List<Menu> menus = menuService.selectMenuList(new Menu());
        List<Long> checkedKeys = menuService.selectMenuListByRoleId(roleId);
        List<MenuTreeVo> menuTreeVos = SystemConverter.buildMenuSelectTree(menus);
        RoleMenuTreeSelectVo vo = new RoleMenuTreeSelectVo(checkedKeys, menuTreeVos);
        return ResponseResult.okResult(vo);
    }
}
