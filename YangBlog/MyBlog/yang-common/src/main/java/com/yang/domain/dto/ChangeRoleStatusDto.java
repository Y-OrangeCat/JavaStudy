package com.yang.domain.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * @Description: 改变角色状态Dto——后台
 * @Author: Mr.Yang
 * @Date: 2023/3/8 12:29
 * @Version: 1.0
 */
@NoArgsConstructor
@AllArgsConstructor
public class ChangeRoleStatusDto {
    private Long roleId;
    private String status;

    public Long getRoleId() {
        return this.roleId;
    }

    public String getStatus() {
        return this.status;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof ChangeRoleStatusDto)) return false;
        final ChangeRoleStatusDto other = (ChangeRoleStatusDto) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$roleId = this.getRoleId();
        final Object other$roleId = other.getRoleId();
        if (this$roleId == null ? other$roleId != null : !this$roleId.equals(other$roleId)) return false;
        final Object this$status = this.getStatus();
        final Object other$status = other.getStatus();
        if (this$status == null ? other$status != null : !this$status.equals(other$status)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof ChangeRoleStatusDto;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $roleId = this.getRoleId();
        result = result * PRIME + ($roleId == null ? 43 : $roleId.hashCode());
        final Object $status = this.getStatus();
        result = result * PRIME + ($status == null ? 43 : $status.hashCode());
        return result;
    }

    public String toString() {
        return "ChangeRoleStatusDto(roleId=" + this.getRoleId() + ", status=" + this.getStatus() + ")";
    }
}
