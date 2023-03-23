package com.yang.controller;

import com.yang.constants.SystemConstants;
import com.yang.domain.ResponseResult;

import com.yang.domain.dto.AddCommentDto;
import com.yang.domain.entity.Comment;
import com.yang.service.CommentService;
import com.yang.utils.BeanCopyUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Description: 评论实现类
 * @Author: Mr.Yang
 * @Date: 2023/1/13 23:59
 * @Version: 1.0
 */
@RestController
@RequestMapping("/comment")
@Api(tags = "评论",description = "评论相关接口")
public class CommentController {
    @Autowired
    private CommentService commentService;

    /**
     * 文章查询评论     localhost:7777/comment/commentList
     * @param articleId
     * @param pageNum
     * @param pageSize
     * @return
     */
    @GetMapping("/commentList")
    public ResponseResult commentList(Long articleId, Integer pageNum, Integer pageSize) {

        return commentService.commentList(SystemConstants.ARTICLE_COMMENT,articleId,pageNum,pageSize);
    }

    /**
     * 友链评论查询    localhost:7777/comment/linkCommentList
     * @param pageNum
     * @return
     */
    @ApiOperation(value = "友链评论列表",notes = "获取一页友联评论")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum",value = "页号"),
            @ApiImplicitParam(name = "pageSize",value = "每页大小")
    })
    @GetMapping("linkCommentList")
    public ResponseResult linkCommentList(Integer pageNum,Integer pageSize){
        return commentService.commentList(SystemConstants.LINK_COMMENT,null,pageNum,pageSize);
    }

    /**
     * 增加文章评论
     * @param addCommentDto
     * @return
     */
    @PostMapping
    public ResponseResult addComment(@RequestBody AddCommentDto addCommentDto){
        Comment comment = BeanCopyUtils.copyBean(addCommentDto, Comment.class);
        return commentService.addComment(comment);
    }

}
