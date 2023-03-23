package com.yang.domain.vo;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * @Description:
 * @Author: Mr.Yang
 * @Date: 2023/3/7 17:31
 * @Version: 1.0
 */
@NoArgsConstructor
@AllArgsConstructor
public class MenuListVo {
    //菜单ID
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
    //是否为外链（0是 1否）
    private Integer isFrame;
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
    //备注
    private String remark;

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

    public Integer getIsFrame() {
        return this.isFrame;
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

    public String getRemark() {
        return this.remark;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public void setComponent(String component) {
        this.component = component;
    }

    public void setIsFrame(Integer isFrame) {
        this.isFrame = isFrame;
    }

    public void setMenuType(String menuType) {
        this.menuType = menuType;
    }

    public void setVisible(String visible) {
        this.visible = visible;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setPerms(String perms) {
        this.perms = perms;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof MenuListVo)) return false;
        final MenuListVo other = (MenuListVo) o;
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
        final Object this$isFrame = this.getIsFrame();
        final Object other$isFrame = other.getIsFrame();
        if (this$isFrame == null ? other$isFrame != null : !this$isFrame.equals(other$isFrame)) return false;
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
        final Object this$remark = this.getRemark();
        final Object other$remark = other.getRemark();
        if (this$remark == null ? other$remark != null : !this$remark.equals(other$remark)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof MenuListVo;
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
        final Object $isFrame = this.getIsFrame();
        result = result * PRIME + ($isFrame == null ? 43 : $isFrame.hashCode());
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
        final Object $remark = this.getRemark();
        result = result * PRIME + ($remark == null ? 43 : $remark.hashCode());
        return result;
    }

    public String toString() {
        return "MenuListVo(id=" + this.getId() + ", menuName=" + this.getMenuName() + ", parentId=" + this.getParentId() + ", orderNum=" + this.getOrderNum() + ", path=" + this.getPath() + ", component=" + this.getComponent() + ", isFrame=" + this.getIsFrame() + ", menuType=" + this.getMenuType() + ", visible=" + this.getVisible() + ", status=" + this.getStatus() + ", perms=" + this.getPerms() + ", icon=" + this.getIcon() + ", remark=" + this.getRemark() + ")";
    }
}
