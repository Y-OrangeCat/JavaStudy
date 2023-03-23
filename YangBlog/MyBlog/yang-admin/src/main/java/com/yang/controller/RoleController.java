package com.yang.controller;

import com.yang.domain.ResponseResult;
import com.yang.domain.dto.ChangeRoleStatusDto;
import com.yang.domain.entity.Role;
import com.yang.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Description: 用户角色控制层
 * @Author: Mr.Yang
 * @Date: 2023/3/7 23:06
 * @Version: 1.0
 */
@RestController
@RequestMapping("/system/role")
public class RoleController {
    @Autowired
    private RoleService roleService;


    /**
     * 查询所有角色
     * @return
     */
    @GetMapping("/listAllRole")
    public ResponseResult listAllRole() {
        List<Role> roles = roleService.selectRoleAll();
        return ResponseResult.okResult(roles);
    }

    /**
     * 分页查询角色列表
     * @return
     */
    @GetMapping("/list")
    public ResponseResult list(Role role,Integer pageNum,Integer pageSize){
        return roleService.selectRolePage(role,pageNum,pageSize);
    }

    /**
     * 改变角色状态
     * @param roleStatusDto
     * @return
     */
    @PutMapping("/changeStatus")
    public ResponseResult changeStatus(@RequestBody ChangeRoleStatusDto roleStatusDto){
        Role role = new Role();
        role.setId(roleStatusDto.getRoleId());
        role.setStatus(roleStatusDto.getStatus());
        roleService.updateById(role);
        return ResponseResult.okResult();
    }

    /**
     * 添加角色
     * @param role
     * @return
     */
    @PostMapping
    public ResponseResult addRole(@RequestBody Role role){
        roleService.insertRole(role);
        return ResponseResult.okResult();
    }

    /**
     * 修改角色——根据角色编号获取详细信息
     */
    @GetMapping("/{roleId}")
    public ResponseResult getInfo(@PathVariable Long roleId){
        Role role = roleService.getById(roleId);
        return ResponseResult.okResult(role);
    }

    /**
     * 修改角色
     * @param role
     * @return
     */
    @PutMapping
    public ResponseResult updateRole(Role role){
        roleService.updateRole(role);
        return ResponseResult.okResult();
    }

    /**
     * 删除角色
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public ResponseResult deleteRole(@PathVariable(name = "id") Long id){
        roleService.removeById(id);
        return ResponseResult.okResult();
    }
}
