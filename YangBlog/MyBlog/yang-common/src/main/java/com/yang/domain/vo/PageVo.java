package com.yang.domain.vo;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Description: 分页Vo
 * @Author: Mr.Yang
 * @Date: 2022/12/5 15:18
 * @Version: 1.0
 */
@AllArgsConstructor
@NoArgsConstructor
public class PageVo {
    //分页对象列表
    private List rows;

    //分页行数（满足条件的行数）
    private Long total;

    public List getRows() {
        return this.rows;
    }

    public Long getTotal() {
        return this.total;
    }

    public void setRows(List rows) {
        this.rows = rows;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof PageVo)) return false;
        final PageVo other = (PageVo) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$rows = this.getRows();
        final Object other$rows = other.getRows();
        if (this$rows == null ? other$rows != null : !this$rows.equals(other$rows)) return false;
        final Object this$total = this.getTotal();
        final Object other$total = other.getTotal();
        if (this$total == null ? other$total != null : !this$total.equals(other$total)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof PageVo;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $rows = this.getRows();
        result = result * PRIME + ($rows == null ? 43 : $rows.hashCode());
        final Object $total = this.getTotal();
        result = result * PRIME + ($total == null ? 43 : $total.hashCode());
        return result;
    }

    public String toString() {
        return "PageVo(rows=" + this.getRows() + ", total=" + this.getTotal() + ")";
    }
}
