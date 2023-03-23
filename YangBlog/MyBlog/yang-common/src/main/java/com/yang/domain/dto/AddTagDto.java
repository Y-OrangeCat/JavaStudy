package com.yang.domain.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * @Description: Tag数据传输对象——新增标签
 * @Author: Mr.Yang
 * @Date: 2023/3/2 23:19
 * @Version: 1.0
 */
@NoArgsConstructor
@AllArgsConstructor
public class AddTagDto {
    //标签名
    private String name;

    //备注
    private String remark;

    public String getName() {
        return this.name;
    }

    public String getRemark() {
        return this.remark;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof AddTagDto)) return false;
        final AddTagDto other = (AddTagDto) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$name = this.getName();
        final Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) return false;
        final Object this$remark = this.getRemark();
        final Object other$remark = other.getRemark();
        if (this$remark == null ? other$remark != null : !this$remark.equals(other$remark)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof AddTagDto;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $name = this.getName();
        result = result * PRIME + ($name == null ? 43 : $name.hashCode());
        final Object $remark = this.getRemark();
        result = result * PRIME + ($remark == null ? 43 : $remark.hashCode());
        return result;
    }

    public String toString() {
        return "AddTagDto(name=" + this.getName() + ", remark=" + this.getRemark() + ")";
    }
}
