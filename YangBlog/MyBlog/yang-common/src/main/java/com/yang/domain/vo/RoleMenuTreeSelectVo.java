package com.yang.domain.vo;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * @Description:
 * @Author: Mr.Yang
 * @Date: 2023/3/8 15:56
 * @Version: 1.0
 */
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class RoleMenuTreeSelectVo {
    private List<Long> checkedKeys;

    private List<MenuTreeVo> menus;

    public List<Long> getCheckedKeys() {
        return this.checkedKeys;
    }

    public List<MenuTreeVo> getMenus() {
        return this.menus;
    }

    public RoleMenuTreeSelectVo setCheckedKeys(List<Long> checkedKeys) {
        this.checkedKeys = checkedKeys;
        return this;
    }

    public RoleMenuTreeSelectVo setMenus(List<MenuTreeVo> menus) {
        this.menus = menus;
        return this;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof RoleMenuTreeSelectVo)) return false;
        final RoleMenuTreeSelectVo other = (RoleMenuTreeSelectVo) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$checkedKeys = this.getCheckedKeys();
        final Object other$checkedKeys = other.getCheckedKeys();
        if (this$checkedKeys == null ? other$checkedKeys != null : !this$checkedKeys.equals(other$checkedKeys))
            return false;
        final Object this$menus = this.getMenus();
        final Object other$menus = other.getMenus();
        if (this$menus == null ? other$menus != null : !this$menus.equals(other$menus)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof RoleMenuTreeSelectVo;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $checkedKeys = this.getCheckedKeys();
        result = result * PRIME + ($checkedKeys == null ? 43 : $checkedKeys.hashCode());
        final Object $menus = this.getMenus();
        result = result * PRIME + ($menus == null ? 43 : $menus.hashCode());
        return result;
    }

    public String toString() {
        return "RoleMenuTreeSelectVo(checkedKeys=" + this.getCheckedKeys() + ", menus=" + this.getMenus() + ")";
    }
}
