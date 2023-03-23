package com.yang.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yang.constants.SystemConstants;
import com.yang.domain.ResponseResult;
import com.yang.domain.entity.Role;
import com.yang.domain.entity.RoleMenu;
import com.yang.domain.vo.PageVo;
import com.yang.mapper.RoleMapper;
import com.yang.service.RoleMenuService;
import com.yang.service.RoleService;
import com.yang.utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 角色信息表(Role)表服务实现类
 *
 * @author makejava
 * @since 2023-02-23 21:16:41
 */
@Service("roleService")
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {
    @Autowired
    private RoleMenuService roleMenuService;
    /**
     * 根据用户id查询角色信息
     * @param id
     * @return
     */
    @Override
    public List<String> selectRolesKeyByUserId(Long id) {
        //判断是否是管理员 如果是返回集合中只需要有admin
        if (SecurityUtils.isAdmin()){
            ArrayList<String> roleKey = new ArrayList<>();
            roleKey.add("admin");
        }
        //否则查询用户所具有的角色信息
        return getBaseMapper().selectRolesKeyByUserId(id);
    }

    /**
     * 查询所有角色
     * @return
     */
    @Override
    public List<Role> selectRoleAll() {
//        LambdaQueryWrapper<Role> queryWrapper = new LambdaQueryWrapper<>();
//        queryWrapper.eq(Role::getStatus, SystemConstants.NORMAL);
//        List<Role> roleList = list(queryWrapper);
//        return roleList;
        return list(Wrappers.<Role>lambdaQuery().eq(Role::getStatus,SystemConstants.NORMAL));
    }

    /**
     * 分页查询角色列表——后台
     * @return
     */
    @Override
    public ResponseResult selectRolePage(Role role, Integer pageNum, Integer pageSize) {
        LambdaQueryWrapper<Role> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.like(StringUtils.hasText(role.getRoleName()),Role::getRoleName,role.getRoleName());
        queryWrapper.eq(StringUtils.hasText(role.getStatus()),Role::getStatus,role.getStatus());
        queryWrapper.orderByAsc(Role::getRoleSort);

        Page<Role> page = new Page<>();
        page.setCurrent(pageNum);
        page.setSize(pageSize);
        page(page,queryWrapper);

        //转换成VO
        List<Role> roles = page.getRecords();

        PageVo pageVo = new PageVo();
        pageVo.setTotal(page.getTotal());
        pageVo.setRows(roles);
        return ResponseResult.okResult(pageVo);
    }

    /**
     * 添加角色——后台
     * @param role
     * @return
     */
    @Override
    @Transactional
    public void insertRole(Role role) {
        save(role);
        System.out.println(role.getId());
        if (role.getMenuIds() != null && role.getMenuIds().length > 0){
            insertRoleMenu(role);
        }
    }

    private void insertRoleMenu(Role role) {
        List<RoleMenu> roleMenuList = Arrays.stream(role.getMenuIds())
                .map(menuId -> new RoleMenu(role.getId(), menuId))
                .collect(Collectors.toList());
        roleMenuService.saveBatch(roleMenuList);
    }

    /**
     * 修改角色——后台
     * @param role
     */
    @Override
    public void updateRole(Role role) {
        updateById(role);
        roleMenuService.deleteRoleMenuByRoleId(role.getId());
        insertRoleMenu(role);

    }

    /**
     * 修改用户时获取用户角色id
     * @param userId
     * @return
     */
    @Override
    public List<Long> selectRoleIdByUserId(Long userId) {
        return getBaseMapper().selectRoleIdByUserId(userId);
    }
}

