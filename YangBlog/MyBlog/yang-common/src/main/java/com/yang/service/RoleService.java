package com.yang.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yang.domain.ResponseResult;
import com.yang.domain.entity.Role;

import java.util.List;

/**
 * 角色信息表(Role)表服务接口
 *
 * @author makejava
 * @since 2023-02-23 21:05:11
 */
public interface RoleService extends IService<Role> {
    /**
     * 根据用户id查询角色信息
     * @param id
     * @return
     */
    List<String> selectRolesKeyByUserId(Long id);

    /**
     * 查询所有角色
     * @return
     */
    List<Role> selectRoleAll();

    /**
     * 分页查询角色列表-后台
     * @return
     */
    ResponseResult selectRolePage(Role role, Integer pageNum, Integer pageSize);

    /**
     * 添加角色
     * @param role
     * @return
     */
    void insertRole(Role role);

    /**
     * 修改角色——后台
     */
    void updateRole(Role role);

    /**
     * 修改用户时获取用户角色id
     * @param userId
     * @return
     */
    List<Long> selectRoleIdByUserId(Long userId);
}

