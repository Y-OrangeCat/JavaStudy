package com.yang.domain.vo;

import com.yang.domain.entity.Role;
import com.yang.domain.entity.User;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Description:
 * @Author: Mr.Yang
 * @Date: 2023/3/8 23:08
 * @Version: 1.0
 */
@AllArgsConstructor
@NoArgsConstructor
public class UserInfoAndRoleIdsVo {
    private User user;
    private List<Role> roles;
    private List<Long> roleIds;

    public User getUser() {
        return this.user;
    }

    public List<Role> getRoles() {
        return this.roles;
    }

    public List<Long> getRoleIds() {
        return this.roleIds;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public void setRoleIds(List<Long> roleIds) {
        this.roleIds = roleIds;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof UserInfoAndRoleIdsVo)) return false;
        final UserInfoAndRoleIdsVo other = (UserInfoAndRoleIdsVo) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$user = this.getUser();
        final Object other$user = other.getUser();
        if (this$user == null ? other$user != null : !this$user.equals(other$user)) return false;
        final Object this$roles = this.getRoles();
        final Object other$roles = other.getRoles();
        if (this$roles == null ? other$roles != null : !this$roles.equals(other$roles)) return false;
        final Object this$roleIds = this.getRoleIds();
        final Object other$roleIds = other.getRoleIds();
        if (this$roleIds == null ? other$roleIds != null : !this$roleIds.equals(other$roleIds)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof UserInfoAndRoleIdsVo;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $user = this.getUser();
        result = result * PRIME + ($user == null ? 43 : $user.hashCode());
        final Object $roles = this.getRoles();
        result = result * PRIME + ($roles == null ? 43 : $roles.hashCode());
        final Object $roleIds = this.getRoleIds();
        result = result * PRIME + ($roleIds == null ? 43 : $roleIds.hashCode());
        return result;
    }

    public String toString() {
        return "UserInfoAndRoleIdsVo(user=" + this.getUser() + ", roles=" + this.getRoles() + ", roleIds=" + this.getRoleIds() + ")";
    }
}
