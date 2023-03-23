package com.yang.domain.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 评论表(Comment)表实体类
 *
 * @author makejava
 * @since 2023-01-13 22:07:13
 */
@ApiModel(description = "评论实体类")
@SuppressWarnings("serial")
@AllArgsConstructor
@NoArgsConstructor
@TableName("sg_comment")
public class Comment  {
    @ApiModelProperty(notes = "评论id")
    @TableId    //表主键标识
    private Long id;

    //评论类型（0代表文章评论，1代表友链评论）
    private String type;
    //文章id
    private Long articleId;
    //根评论id
    private Long rootId;
    //评论内容
    private String content;
    //所回复的目标评论的userid
    private Long toCommentUserId;
    //回复目标评论id
    private Long toCommentId;

    @TableField(fill = FieldFill.INSERT)
    private Long createBy;

    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Long updateBy;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

    //删除标志（0代表未删除，1代表已删除）
    private Integer delFlag;

    public Long getId() {
        return this.id;
    }

    public String getType() {
        return this.type;
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

    public Long getToCommentId() {
        return this.toCommentId;
    }

    public Long getCreateBy() {
        return this.createBy;
    }

    public Date getCreateTime() {
        return this.createTime;
    }

    public Long getUpdateBy() {
        return this.updateBy;
    }

    public Date getUpdateTime() {
        return this.updateTime;
    }

    public Integer getDelFlag() {
        return this.delFlag;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setType(String type) {
        this.type = type;
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

    public void setToCommentId(Long toCommentId) {
        this.toCommentId = toCommentId;
    }

    public void setCreateBy(Long createBy) {
        this.createBy = createBy;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public void setUpdateBy(Long updateBy) {
        this.updateBy = updateBy;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Comment)) return false;
        final Comment other = (Comment) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        final Object this$type = this.getType();
        final Object other$type = other.getType();
        if (this$type == null ? other$type != null : !this$type.equals(other$type)) return false;
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
        final Object this$updateBy = this.getUpdateBy();
        final Object other$updateBy = other.getUpdateBy();
        if (this$updateBy == null ? other$updateBy != null : !this$updateBy.equals(other$updateBy)) return false;
        final Object this$updateTime = this.getUpdateTime();
        final Object other$updateTime = other.getUpdateTime();
        if (this$updateTime == null ? other$updateTime != null : !this$updateTime.equals(other$updateTime))
            return false;
        final Object this$delFlag = this.getDelFlag();
        final Object other$delFlag = other.getDelFlag();
        if (this$delFlag == null ? other$delFlag != null : !this$delFlag.equals(other$delFlag)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Comment;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $type = this.getType();
        result = result * PRIME + ($type == null ? 43 : $type.hashCode());
        final Object $articleId = this.getArticleId();
        result = result * PRIME + ($articleId == null ? 43 : $articleId.hashCode());
        final Object $rootId = this.getRootId();
        result = result * PRIME + ($rootId == null ? 43 : $rootId.hashCode());
        final Object $content = this.getContent();
        result = result * PRIME + ($content == null ? 43 : $content.hashCode());
        final Object $toCommentUserId = this.getToCommentUserId();
        result = result * PRIME + ($toCommentUserId == null ? 43 : $toCommentUserId.hashCode());
        final Object $toCommentId = this.getToCommentId();
        result = result * PRIME + ($toCommentId == null ? 43 : $toCommentId.hashCode());
        final Object $createBy = this.getCreateBy();
        result = result * PRIME + ($createBy == null ? 43 : $createBy.hashCode());
        final Object $createTime = this.getCreateTime();
        result = result * PRIME + ($createTime == null ? 43 : $createTime.hashCode());
        final Object $updateBy = this.getUpdateBy();
        result = result * PRIME + ($updateBy == null ? 43 : $updateBy.hashCode());
        final Object $updateTime = this.getUpdateTime();
        result = result * PRIME + ($updateTime == null ? 43 : $updateTime.hashCode());
        final Object $delFlag = this.getDelFlag();
        result = result * PRIME + ($delFlag == null ? 43 : $delFlag.hashCode());
        return result;
    }

    public String toString() {
        return "Comment(id=" + this.getId() + ", type=" + this.getType() + ", articleId=" + this.getArticleId() + ", rootId=" + this.getRootId() + ", content=" + this.getContent() + ", toCommentUserId=" + this.getToCommentUserId() + ", toCommentId=" + this.getToCommentId() + ", createBy=" + this.getCreateBy() + ", createTime=" + this.getCreateTime() + ", updateBy=" + this.getUpdateBy() + ", updateTime=" + this.getUpdateTime() + ", delFlag=" + this.getDelFlag() + ")";
    }
}
