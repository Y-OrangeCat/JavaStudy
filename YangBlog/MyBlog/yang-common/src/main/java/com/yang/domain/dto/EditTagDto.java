package com.yang.domain.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * @Description: Tag数据传输对象——修改标签
 * @Author: Mr.Yang
 * @Date: 2023/3/2 23:43
 * @Version: 1.0
 */
@AllArgsConstructor
@NoArgsConstructor
public class EditTagDto {
    private Long id;
    //备注
    private String remark;
    //标签名
    private String name;

    public Long getId() {
        return this.id;
    }

    public String getRemark() {
        return this.remark;
    }

    public String getName() {
        return this.name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof EditTagDto)) return false;
        final EditTagDto other = (EditTagDto) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        final Object this$remark = this.getRemark();
        final Object other$remark = other.getRemark();
        if (this$remark == null ? other$remark != null : !this$remark.equals(other$remark)) return false;
        final Object this$name = this.getName();
        final Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof EditTagDto;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $remark = this.getRemark();
        result = result * PRIME + ($remark == null ? 43 : $remark.hashCode());
        final Object $name = this.getName();
        result = result * PRIME + ($name == null ? 43 : $name.hashCode());
        return result;
    }

    public String toString() {
        return "EditTagDto(id=" + this.getId() + ", remark=" + this.getRemark() + ", name=" + this.getName() + ")";
    }
}
