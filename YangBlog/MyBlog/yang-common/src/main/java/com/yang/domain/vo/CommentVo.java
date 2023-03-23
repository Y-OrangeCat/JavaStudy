package com.yang.domain.vo;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

/**
 * @Description: VO（View Object）：显示层对象，通常是 Web 向模板渲染引擎层传输的对象
 * @Author: Mr.Yang
 * @Date: 2023/1/14 1:01
 * @Version: 1.0
 */
@AllArgsConstructor
@NoArgsConstructor
public class CommentVo {
    private Long id;

    //文章id
    private Long articleId;
    //根评论id
    private Long rootId;
    //评论内容
    private String content;
    //所回复的目标评论的userid
    private Long toCommentUserId;
    private String toCommentUserName;
    //回复目标评论id
    private Long toCommentId;

    private Long createBy;

    private Date createTime;

    private String username;

    private List<CommentVo> children;

    public Long getId() {
        return this.id;
    }

    public Long getArticleId() {
        return this.articleId;
    }

    public Long getRootId() {
        return this.rootId;
    }

    public String getContent() {
        return this.content;
    }

    public Long getToCommentUserId() {
        return this.toCommentUserId;
    }

    public String getToCommentUserName() {
        return this.toCommentUserName;
    }

    public Long getToCommentId() {
        return this.toCommentId;
    }

    public Long getCreateBy() {
        return this.createBy;
    }

    public Date getCreateTime() {
        return this.createTime;
    }

    public String getUsername() {
        return this.username;
    }

    public List<CommentVo> getChildren() {
        return this.children;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setArticleId(Long articleId) {
        this.articleId = articleId;
    }

    public void setRootId(Long rootId) {
        this.rootId = rootId;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setToCommentUserId(Long toCommentUserId) {
        this.toCommentUserId = toCommentUserId;
    }

    public void setToCommentUserName(String toCommentUserName) {
        this.toCommentUserName = toCommentUserName;
    }

    public void setToCommentId(Long toCommentId) {
        this.toCommentId = toCommentId;
    }

    public void setCreateBy(Long createBy) {
        this.createBy = createBy;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setChildren(List<CommentVo> children) {
        this.children = children;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof CommentVo)) return false;
        final CommentVo other = (CommentVo) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        final Object this$articleId = this.getArticleId();
        final Object other$articleId = other.getArticleId();
        if (this$articleId == null ? other$articleId != null : !this$articleId.equals(other$articleId)) return false;
        final Object this$rootId = this.getRootId();
        final Object other$rootId = other.getRootId();
        if (this$rootId == null ? other$rootId != null : !this$rootId.equals(other$rootId)) return false;
        final Object this$content = this.getContent();
        final Object other$content = other.getContent();
        if (this$content == null ? other$content != null : !this$content.equals(other$content)) return false;
        final Object this$toCommentUserId = this.getToCommentUserId();
        final Object other$toCommentUserId = other.getToCommentUserId();
        if (this$toCommentUserId == null ? other$toCommentUserId != null : !this$toCommentUserId.equals(other$toCommentUserId))
            return false;
        final Object this$toCommentUserName = this.getToCommentUserName();
        final Object other$toCommentUserName = other.getToCommentUserName();
        if (this$toCommentUserName == null ? other$toCommentUserName != null : !this$toCommentUserName.equals(other$toCommentUserName))
            return false;
        final Object this$toCommentId = this.getToCommentId();
        final Object other$toCommentId = other.getToCommentId();
        if (this$toCommentId == null ? other$toCommentId != null : !this$toCommentId.equals(other$toCommentId))
            return false;
        final Object this$createBy = this.getCreateBy();
        final Object other$createBy = other.getCreateBy();
        if (this$createBy == null ? other$createBy != null : !this$createBy.equals(other$createBy)) return false;
        final Object this$createTime = this.getCreateTime();
        final Object other$createTime = other.getCreateTime();
        if (this$createTime == null ? other$createTime != null : !this$createTime.equals(other$createTime))
            return false;
        final Object this$username = this.getUsername();
        final Object other$username = other.getUsername();
        if (this$username == null ? other$username != null : !this$username.equals(other$username)) return false;
        final Object this$children = this.getChildren();
        final Object other$children = other.getChildren();
        if (this$children == null ? other$children != null : !this$children.equals(other$children)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof CommentVo;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $articleId = this.getArticleId();
        result = result * PRIME + ($articleId == null ? 43 : $articleId.hashCode());
        final Object $rootId = this.getRootId();
        result = result * PRIME + ($rootId == null ? 43 : $rootId.hashCode());
        final Object $content = this.getContent();
        result = result * PRIME + ($content == null ? 43 : $content.hashCode());
        final Object $toCommentUserId = this.getToCommentUserId();
        result = result * PRIME + ($toCommentUserId == null ? 43 : $toCommentUserId.hashCode());
        final Object $toCommentUserName = this.getToCommentUserName();
        result = result * PRIME + ($toCommentUserName == null ? 43 : $toCommentUserName.hashCode());
        final Object $toCommentId = this.getToCommentId();
        result = result * PRIME + ($toCommentId == null ? 43 : $toCommentId.hashCode());
        final Object $createBy = this.getCreateBy();
        result = result * PRIME + ($createBy == null ? 43 : $createBy.hashCode());
        final Object $createTime = this.getCreateTime();
        result = result * PRIME + ($createTime == null ? 43 : $createTime.hashCode());
        final Object $username = this.getUsername();
        result = result * PRIME + ($username == null ? 43 : $username.hashCode());
        final Object $children = this.getChildren();
        result = result * PRIME + ($children == null ? 43 : $children.hashCode());
        return result;
    }

    public String toString() {
        return "CommentVo(id=" + this.getId() + ", articleId=" + this.getArticleId() + ", rootId=" + this.getRootId() + ", content=" + this.getContent() + ", toCommentUserId=" + this.getToCommentUserId() + ", toCommentUserName=" + this.getToCommentUserName() + ", toCommentId=" + this.getToCommentId() + ", createBy=" + this.getCreateBy() + ", createTime=" + this.getCreateTime() + ", username=" + this.getUsername() + ", children=" + this.getChildren() + ")";
    }
}
