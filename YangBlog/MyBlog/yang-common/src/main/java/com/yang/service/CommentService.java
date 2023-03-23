package com.yang.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yang.domain.ResponseResult;
import com.yang.domain.entity.Comment;

/**
 * 评论表(Comment)表服务接口
 *
 * @author makejava
 * @since 2023-01-13 22:07:15
 */
public interface CommentService extends IService<Comment> {
    /**
     * 查询评论列表
     *
     * @param commentType
     * @param articleId
     * @param pageNum
     * @param pageSize
     * @return
     */
    ResponseResult commentList(String commentType, Long articleId, Integer pageNum, Integer pageSize);

    /**
     * 增加评论
     * @param comment
     * @return
     */
    ResponseResult addComment(Comment comment);
}

