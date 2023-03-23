package com.yang.domain.vo;

import com.yang.domain.entity.Menu;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Date;
import java.util.List;

/**
 * @Description:
 * @Author: Mr.Yang
 * @Date: 2023/2/25 23:58
 * @Version: 1.0
 */
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class MenuVo {
    private Long id;
    //菜单名称
    private String menuName;
    //父菜单ID
    private Long parentId;
    //显示顺序
    private Integer orderNum;
    //路由地址
    private String path;
    //组件路径
    private String component;
    //菜单类型（M目录 C菜单 F按钮）
    private String menuType;
    //菜单状态（0显示 1隐藏）
    private String visible;
    //菜单状态（0正常 1停用）
    private String status;
    //权限标识
    private String perms;
    //菜单图标
    private String icon;
    //创建时间
    private Date createTime;

    private List<Menu> children;

    public Long getId() {
        return this.id;
    }

    public String getMenuName() {
        return this.menuName;
    }

    public Long getParentId() {
        return this.parentId;
    }

    public Integer getOrderNum() {
        return this.orderNum;
    }

    public String getPath() {
        return this.path;
    }

    public String getComponent() {
        return this.component;
    }

    public String getMenuType() {
        return this.menuType;
    }

    public String getVisible() {
        return this.visible;
    }

    public String getStatus() {
        return this.status;
    }

    public String getPerms() {
        return this.perms;
    }

    public String getIcon() {
        return this.icon;
    }

    public Date getCreateTime() {
        return this.createTime;
    }

    public List<Menu> getChildren() {
        return this.children;
    }

    public MenuVo setId(Long id) {
        this.id = id;
        return this;
    }

    public MenuVo setMenuName(String menuName) {
        this.menuName = menuName;
        return this;
    }

    public MenuVo setParentId(Long parentId) {
        this.parentId = parentId;
        return this;
    }

    public MenuVo setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
        return this;
    }

    public MenuVo setPath(String path) {
        this.path = path;
        return this;
    }

    public MenuVo setComponent(String component) {
        this.component = component;
        return this;
    }

    public MenuVo setMenuType(String menuType) {
        this.menuType = menuType;
        return this;
    }

    public MenuVo setVisible(String visible) {
        this.visible = visible;
        return this;
    }

    public MenuVo setStatus(String status) {
        this.status = status;
        return this;
    }

    public MenuVo setPerms(String perms) {
        this.perms = perms;
        return this;
    }

    public MenuVo setIcon(String icon) {
        this.icon = icon;
        return this;
    }

    public MenuVo setCreateTime(Date createTime) {
        this.createTime = createTime;
        return this;
    }

    public MenuVo setChildren(List<Menu> children) {
        this.children = children;
        return this;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof MenuVo)) return false;
        final MenuVo other = (MenuVo) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        final Object this$menuName = this.getMenuName();
        final Object other$menuName = other.getMenuName();
        if (this$menuName == null ? other$menuName != null : !this$menuName.equals(other$menuName)) return false;
        final Object this$parentId = this.getParentId();
        final Object other$parentId = other.getParentId();
        if (this$parentId == null ? other$parentId != null : !this$parentId.equals(other$parentId)) return false;
        final Object this$orderNum = this.getOrderNum();
        final Object other$orderNum = other.getOrderNum();
        if (this$orderNum == null ? other$orderNum != null : !this$orderNum.equals(other$orderNum)) return false;
        final Object this$path = this.getPath();
        final Object other$path = other.getPath();
        if (this$path == null ? other$path != null : !this$path.equals(other$path)) return false;
        final Object this$component = this.getComponent();
        final Object other$component = other.getComponent();
        if (this$component == null ? other$component != null : !this$component.equals(other$component)) return false;
        final Object this$menuType = this.getMenuType();
        final Object other$menuType = other.getMenuType();
        if (this$menuType == null ? other$menuType != null : !this$menuType.equals(other$menuType)) return false;
        final Object this$visible = this.getVisible();
        final Object other$visible = other.getVisible();
        if (this$visible == null ? other$visible != null : !this$visible.equals(other$visible)) return false;
        final Object this$status = this.getStatus();
        final Object other$status = other.getStatus();
        if (this$status == null ? other$status != null : !this$status.equals(other$status)) return false;
        final Object this$perms = this.getPerms();
        final Object other$perms = other.getPerms();
        if (this$perms == null ? other$perms != null : !this$perms.equals(other$perms)) return false;
        final Object this$icon = this.getIcon();
        final Object other$icon = other.getIcon();
        if (this$icon == null ? other$icon != null : !this$icon.equals(other$icon)) return false;
        final Object this$createTime = this.getCreateTime();
        final Object other$createTime = other.getCreateTime();
        if (this$createTime == null ? other$createTime != null : !this$createTime.equals(other$createTime))
            return false;
        final Object this$children = this.getChildren();
        final Object other$children = other.getChildren();
        if (this$children == null ? other$children != null : !this$children.equals(other$children)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof MenuVo;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $menuName = this.getMenuName();
        result = result * PRIME + ($menuName == null ? 43 : $menuName.hashCode());
        final Object $parentId = this.getParentId();
        result = result * PRIME + ($parentId == null ? 43 : $parentId.hashCode());
        final Object $orderNum = this.getOrderNum();
        result = result * PRIME + ($orderNum == null ? 43 : $orderNum.hashCode());
        final Object $path = this.getPath();
        result = result * PRIME + ($path == null ? 43 : $path.hashCode());
        final Object $component = this.getComponent();
        result = result * PRIME + ($component == null ? 43 : $component.hashCode());
        final Object $menuType = this.getMenuType();
        result = result * PRIME + ($menuType == null ? 43 : $menuType.hashCode());
        final Object $visible = this.getVisible();
        result = result * PRIME + ($visible == null ? 43 : $visible.hashCode());
        final Object $status = this.getStatus();
        result = result * PRIME + ($status == null ? 43 : $status.hashCode());
        final Object $perms = this.getPerms();
        result = result * PRIME + ($perms == null ? 43 : $perms.hashCode());
        final Object $icon = this.getIcon();
        result = result * PRIME + ($icon == null ? 43 : $icon.hashCode());
        final Object $createTime = this.getCreateTime();
        result = result * PRIME + ($createTime == null ? 43 : $createTime.hashCode());
        final Object $children = this.getChildren();
        result = result * PRIME + ($children == null ? 43 : $children.hashCode());
        return result;
    }

    public String toString() {
        return "MenuVo(id=" + this.getId() + ", menuName=" + this.getMenuName() + ", parentId=" + this.getParentId() + ", orderNum=" + this.getOrderNum() + ", path=" + this.getPath() + ", component=" + this.getComponent() + ", menuType=" + this.getMenuType() + ", visible=" + this.getVisible() + ", status=" + this.getStatus() + ", perms=" + this.getPerms() + ", icon=" + this.getIcon() + ", createTime=" + this.getCreateTime() + ", children=" + this.getChildren() + ")";
    }
}
