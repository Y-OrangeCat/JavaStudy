package com.yang.controller;

import com.yang.domain.ResponseResult;
import com.yang.domain.entity.LoginUser;
import com.yang.domain.entity.Menu;
import com.yang.domain.entity.Role;
import com.yang.domain.entity.User;
import com.yang.domain.vo.AdminUserInfoVo;
import com.yang.domain.vo.RoutersVo;
import com.yang.domain.vo.UserInfoVo;
import com.yang.enums.AppHttpCodeEnum;
import com.yang.exception.SystemException;
import com.yang.service.LoginService;
import com.yang.service.MenuService;
import com.yang.service.RoleService;
import com.yang.utils.BeanCopyUtils;
import com.yang.utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Description: 用户管理接口实现类--后台
 * @Author: Mr.Yang
 * @Date: 2022/12/8 20:21
 * @Version: 1.0
 */
@RestController
public class LoginController {
    @Autowired
    private LoginService loginService;
    @Autowired
    private MenuService menuService;
    @Autowired
    private RoleService roleService;

    /**
     * 后台登录
     *
     * @param user
     * @return
     */
    @PostMapping("/user/login")     //localhost:7777/login
    public ResponseResult user(@RequestBody User user) {
        if (!StringUtils.hasText(user.getUserName())) {
            //提示必须要传入用户名
            throw new SystemException(AppHttpCodeEnum.REQUIRE_USERNAME);
        }
        return loginService.login(user);
    }

    /**
     * 获取用户信息
     *
     * @return
     */
    @GetMapping("/getInfo")
    public ResponseResult<AdminUserInfoVo> getInfo() {
        //获取当前登录的用户
        LoginUser loginUser = SecurityUtils.getLoginUser();
        //根据id查询权限信息
        List<String> perms = menuService.selectPermsByUserId(loginUser.getUser().getId());
        //根据用户id查询角色信息
        List<String> rolesKeyList = roleService.selectRolesKeyByUserId(loginUser.getUser().getId());

        //获取用户信息
        User user = loginUser.getUser();
        UserInfoVo userInfoVo = BeanCopyUtils.copyBean(user, UserInfoVo.class);
        //封装数据返回
        AdminUserInfoVo adminUserInfoVo = new AdminUserInfoVo(perms, rolesKeyList, userInfoVo);

        return ResponseResult.okResult(adminUserInfoVo);
    }

    /**
     * 查询用户菜单信息
     * @return
     */
    @GetMapping("/getRouters")
    public ResponseResult<RoutersVo> getRouters() {
        Long userId = SecurityUtils.getUserId();
        //查询menu 结果是tree的形式
        List<Menu> menus = menuService.selectRouterMenuTreeByUserId(userId);
        //封装数据返回
        return ResponseResult.okResult(new RoutersVo(menus));
    }

    /**
     * 退出登录
     * @return
     */
    @PostMapping("/user/logout")
    public ResponseResult logout(){
        return loginService.logout();
    }
}
