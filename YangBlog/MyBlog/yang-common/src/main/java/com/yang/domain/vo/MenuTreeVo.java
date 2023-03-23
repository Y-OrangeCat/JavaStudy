package com.yang.domain.vo;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * @Description: 菜单树Vo
 * @Author: Mr.Yang
 * @Date: 2023/3/8 15:50
 * @Version: 1.0
 */
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class MenuTreeVo {

    private static final long serialVersionUID = 1L;

    /**
     * 节点ID
     */
    private Long id;

    /**
     * 节点名称
     */
    private String label;

    private Long parentId;

    /**
     * 子节点
     */
//    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<MenuTreeVo> children;

    public Long getId() {
        return this.id;
    }

    public String getLabel() {
        return this.label;
    }

    public Long getParentId() {
        return this.parentId;
    }

    public List<MenuTreeVo> getChildren() {
        return this.children;
    }

    public MenuTreeVo setId(Long id) {
        this.id = id;
        return this;
    }

    public MenuTreeVo setLabel(String label) {
        this.label = label;
        return this;
    }

    public MenuTreeVo setParentId(Long parentId) {
        this.parentId = parentId;
        return this;
    }

    public MenuTreeVo setChildren(List<MenuTreeVo> children) {
        this.children = children;
        return this;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof MenuTreeVo)) return false;
        final MenuTreeVo other = (MenuTreeVo) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        final Object this$label = this.getLabel();
        final Object other$label = other.getLabel();
        if (this$label == null ? other$label != null : !this$label.equals(other$label)) return false;
        final Object this$parentId = this.getParentId();
        final Object other$parentId = other.getParentId();
        if (this$parentId == null ? other$parentId != null : !this$parentId.equals(other$parentId)) return false;
        final Object this$children = this.getChildren();
        final Object other$children = other.getChildren();
        if (this$children == null ? other$children != null : !this$children.equals(other$children)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof MenuTreeVo;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $label = this.getLabel();
        result = result * PRIME + ($label == null ? 43 : $label.hashCode());
        final Object $parentId = this.getParentId();
        result = result * PRIME + ($parentId == null ? 43 : $parentId.hashCode());
        final Object $children = this.getChildren();
        result = result * PRIME + ($children == null ? 43 : $children.hashCode());
        return result;
    }

    public String toString() {
        return "MenuTreeVo(id=" + this.getId() + ", label=" + this.getLabel() + ", parentId=" + this.getParentId() + ", children=" + this.getChildren() + ")";
    }
}
