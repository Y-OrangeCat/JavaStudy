package com.yang.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yang.domain.entity.Menu;

import java.util.List;


/**
 * 菜单权限表(Menu)表数据库访问层
 *
 * @author makejava
 * @since 2023-02-23 21:04:42
 */
public interface MenuMapper extends BaseMapper<Menu> {

    /**
     * 查询用户权限信息
     * @param userId
     * @return
     */
    List<String> selectPermsByUserId(Long userId);

    /**
     * 查询管理员所有菜单
     * @return
     */
    List<Menu> selectAllRouterMenu();

    /**
     * 查询用户所拥有的菜单
     * @param userId
     * @return
     */
    List<Menu> selectRouterMenuTreeByUserId(Long userId);

    /**
     * 查询角色的菜单id
     * @param roleId
     * @return
     */
    List<Long> selectMenuListByRoleId(Long roleId);
}
