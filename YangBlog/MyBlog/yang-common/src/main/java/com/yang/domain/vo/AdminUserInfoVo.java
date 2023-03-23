package com.yang.domain.vo;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * @Description: 后台用户信息Vo
 * @Author: Mr.Yang
 * @Date: 2023/2/23 21:19
 * @Version: 1.0
 */
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class AdminUserInfoVo {
    private List<String> permission;

    private List<String> roles;

    private UserInfoVo user;

    public List<String> getPermission() {
        return this.permission;
    }

    public List<String> getRoles() {
        return this.roles;
    }

    public UserInfoVo getUser() {
        return this.user;
    }

    public AdminUserInfoVo setPermission(List<String> permission) {
        this.permission = permission;
        return this;
    }

    public AdminUserInfoVo setRoles(List<String> roles) {
        this.roles = roles;
        return this;
    }

    public AdminUserInfoVo setUser(UserInfoVo user) {
        this.user = user;
        return this;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof AdminUserInfoVo)) return false;
        final AdminUserInfoVo other = (AdminUserInfoVo) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$permission = this.getPermission();
        final Object other$permission = other.getPermission();
        if (this$permission == null ? other$permission != null : !this$permission.equals(other$permission))
            return false;
        final Object this$roles = this.getRoles();
        final Object other$roles = other.getRoles();
        if (this$roles == null ? other$roles != null : !this$roles.equals(other$roles)) return false;
        final Object this$user = this.getUser();
        final Object other$user = other.getUser();
        if (this$user == null ? other$user != null : !this$user.equals(other$user)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof AdminUserInfoVo;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $permission = this.getPermission();
        result = result * PRIME + ($permission == null ? 43 : $permission.hashCode());
        final Object $roles = this.getRoles();
        result = result * PRIME + ($roles == null ? 43 : $roles.hashCode());
        final Object $user = this.getUser();
        result = result * PRIME + ($user == null ? 43 : $user.hashCode());
        return result;
    }

    public String toString() {
        return "AdminUserInfoVo(permission=" + this.getPermission() + ", roles=" + this.getRoles() + ", user=" + this.getUser() + ")";
    }
}
