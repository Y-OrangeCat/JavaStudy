package com.yang.domain.vo;

import com.yang.domain.entity.Comment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

/**
 * @Description: VO（View Object）：显示层对象，通常是 Web 向模板渲染引擎层传输的对象
 * @Author: Mr.Yang
 * @Date: 2023/1/14 1:01
 * @Version: 1.0
 */
@Data
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
}
