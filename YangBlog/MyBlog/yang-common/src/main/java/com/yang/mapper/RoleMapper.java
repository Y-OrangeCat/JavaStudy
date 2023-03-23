package com.yang.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yang.domain.entity.Role;

import java.util.List;


/**
 * 角色信息表(Role)表数据库访问层
 *
 * @author makejava
 * @since 2023-02-23 21:05:10
 */
public interface RoleMapper extends BaseMapper<Role> {
    /**
     * 查询用户所具有的角色信息
     * @param userId
     * @return
     */
    List<String> selectRolesKeyByUserId(Long userId);

    /**
     * 修改用户时获取用户角色id
     * @param userId
     * @return
     */
    List<Long> selectRoleIdByUserId(Long userId);
}
