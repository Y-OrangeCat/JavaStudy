package com.yang.domain.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @Description: DTO（Data Transfer Object）：数据传输对象，Service 或 Manager 向外传输的对象。
 * @Author: Mr.Yang
 * @Date: 2023/2/19 22:53
 * @Version: 1.0
 */
@ApiModel(description = "添加评论dto")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddCommentDto {
    private Long id;

    //评论类型（0代表文章评论，1代表友链评论）
    @ApiModelProperty(notes = "评论类型（0代表文章评论，1代表友链评论）")
    private String type;
    //文章id
    @ApiModelProperty(notes = "文章id")
    private Long articleId;
    //根评论id
    private Long rootId;
    //评论内容
    private String content;
    //所回复的目标评论的userid
    private Long toCommentUserId;
    //回复目标评论id
    private Long toCommentId;

    private Long createBy;

    private Date createTime;

    private Long updateBy;

    private Date updateTime;

    //删除标志（0代表未删除，1代表已删除）
    private Integer delFlag;
}
