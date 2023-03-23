package com.yang.domain.entity;


import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 文章标签关联表(ArticleTag)表实体类
 *
 * @author makejava
 * @since 2023-03-03 23:56:51
 */
@SuppressWarnings("serial")
@AllArgsConstructor
@NoArgsConstructor
@TableName("sg_article_tag")
public class ArticleTag implements Serializable{
    private static final Long serialVersionUID = 625337492348897098L;

    //文章id@TableId
    private Long articleId;
    //标签id@TableId
    private Long tagId;


    public Long getArticleId() {
        return this.articleId;
    }

    public Long getTagId() {
        return this.tagId;
    }

    public void setArticleId(Long articleId) {
        this.articleId = articleId;
    }

    public void setTagId(Long tagId) {
        this.tagId = tagId;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof ArticleTag)) return false;
        final ArticleTag other = (ArticleTag) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$articleId = this.getArticleId();
        final Object other$articleId = other.getArticleId();
        if (this$articleId == null ? other$articleId != null : !this$articleId.equals(other$articleId)) return false;
        final Object this$tagId = this.getTagId();
        final Object other$tagId = other.getTagId();
        if (this$tagId == null ? other$tagId != null : !this$tagId.equals(other$tagId)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof ArticleTag;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $articleId = this.getArticleId();
        result = result * PRIME + ($articleId == null ? 43 : $articleId.hashCode());
        final Object $tagId = this.getTagId();
        result = result * PRIME + ($tagId == null ? 43 : $tagId.hashCode());
        return result;
    }

    public String toString() {
        return "ArticleTag(articleId=" + this.getArticleId() + ", tagId=" + this.getTagId() + ")";
    }
}
