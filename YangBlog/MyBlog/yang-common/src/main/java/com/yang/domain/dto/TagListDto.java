package com.yang.domain.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * @Description: Tag数据传输对象
 * @Author: Mr.Yang
 * @Date: 2023/2/26 22:51
 * @Version: 1.0
 */
@NoArgsConstructor
@AllArgsConstructor
public class TagListDto {
    private Long id;
    private String name;
    private String remark;

    public Long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getRemark() {
        return this.remark;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof TagListDto)) return false;
        final TagListDto other = (TagListDto) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        final Object this$name = this.getName();
        final Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) return false;
        final Object this$remark = this.getRemark();
        final Object other$remark = other.getRemark();
        if (this$remark == null ? other$remark != null : !this$remark.equals(other$remark)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof TagListDto;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $name = this.getName();
        result = result * PRIME + ($name == null ? 43 : $name.hashCode());
        final Object $remark = this.getRemark();
        result = result * PRIME + ($remark == null ? 43 : $remark.hashCode());
        return result;
    }

    public String toString() {
        return "TagListDto(id=" + this.getId() + ", name=" + this.getName() + ", remark=" + this.getRemark() + ")";
    }
}
