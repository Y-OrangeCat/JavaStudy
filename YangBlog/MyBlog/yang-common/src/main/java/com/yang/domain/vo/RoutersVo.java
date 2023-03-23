package com.yang.domain.vo;

import com.yang.domain.entity.Menu;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Description: 后台用户菜单信息Vo
 * @Author: Mr.Yang
 * @Date: 2023/2/24 23:27
 * @Version: 1.0
 */
@NoArgsConstructor
@AllArgsConstructor
public class RoutersVo {
    private List<Menu> menus;

    public List<Menu> getMenus() {
        return this.menus;
    }

    public void setMenus(List<Menu> menus) {
        this.menus = menus;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof RoutersVo)) return false;
        final RoutersVo other = (RoutersVo) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$menus = this.getMenus();
        final Object other$menus = other.getMenus();
        if (this$menus == null ? other$menus != null : !this$menus.equals(other$menus)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof RoutersVo;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $menus = this.getMenus();
        result = result * PRIME + ($menus == null ? 43 : $menus.hashCode());
        return result;
    }

    public String toString() {
        return "RoutersVo(menus=" + this.getMenus() + ")";
    }
}
