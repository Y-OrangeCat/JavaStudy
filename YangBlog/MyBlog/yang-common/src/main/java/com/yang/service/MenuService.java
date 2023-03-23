package com.yang.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yang.domain.entity.Menu;

import java.util.List;

/**
 * 菜单权限表(Menu)表服务接口
 *
 * @author makejava
 * @since 2023-02-23 21:04:44
 */
public interface MenuService extends IService<Menu> {
    /**
     * 根据id查询权限信息
     * @param id
     * @return
     */
    List<String> selectPermsByUserId(Long id);

    /**
     * 查询menu 结果是tree的形式
     * @param userId
     * @return
     */
    List<Menu> selectRouterMenuTreeByUserId(Long userId);

    /**
     * 获取菜单列表——后台
     * @param menu
     * @return
     */
    List<Menu> selectMenuList(Menu menu);

    /**
     * 查询子菜单
     * @param menuId
     * @return
     */
    boolean hasChild(Long menuId);

    /**
     * 加载对应角色菜单列表树
     */
    List<Long> selectMenuListByRoleId(Long roleId);
}

