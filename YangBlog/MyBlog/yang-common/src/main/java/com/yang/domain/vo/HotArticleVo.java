package com.yang.domain.vo;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * @Description: 热门文章
 * @Author: Mr.Yang
 * @Date: 2022/12/3 23:05
 * @Version: 1.0
 */
@NoArgsConstructor
@AllArgsConstructor
public class HotArticleVo {
    //id
    private Long id;
    //标题
    private String title;
    //访问量
    private Long viewCount;

    public Long getId() {
        return this.id;
    }

    public String getTitle() {
        return this.title;
    }

    public Long getViewCount() {
        return this.viewCount;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setViewCount(Long viewCount) {
        this.viewCount = viewCount;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof HotArticleVo)) return false;
        final HotArticleVo other = (HotArticleVo) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        final Object this$title = this.getTitle();
        final Object other$title = other.getTitle();
        if (this$title == null ? other$title != null : !this$title.equals(other$title)) return false;
        final Object this$viewCount = this.getViewCount();
        final Object other$viewCount = other.getViewCount();
        if (this$viewCount == null ? other$viewCount != null : !this$viewCount.equals(other$viewCount)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof HotArticleVo;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $title = this.getTitle();
        result = result * PRIME + ($title == null ? 43 : $title.hashCode());
        final Object $viewCount = this.getViewCount();
        result = result * PRIME + ($viewCount == null ? 43 : $viewCount.hashCode());
        return result;
    }

    public String toString() {
        return "HotArticleVo(id=" + this.getId() + ", title=" + this.getTitle() + ", viewCount=" + this.getViewCount() + ")";
    }
}
