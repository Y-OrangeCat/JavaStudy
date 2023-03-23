package com.yang.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yang.domain.ResponseResult;
import com.yang.domain.dto.AddArticleDto;
import com.yang.domain.dto.ArticleDto;
import com.yang.domain.entity.Article;
import com.yang.domain.vo.ArticleVo;
import com.yang.domain.vo.PageVo;

/**
 * @Description: 博客文章接口
 * @Author: Mr.Yang
 * @Date: 2022/11/22 20:19
 * @Version: 1.0
 */
public interface ArticleService extends IService<Article> {
    /**
     * 热门文章
     * @return
     */
    ResponseResult hotArticleList();

    /**
     * 分类文章列表
     * @param pageNum
     * @param pageSize
     * @param categoryId
     * @return
     */
    ResponseResult articleList(Integer pageNum, Integer pageSize, Long categoryId);

    /**
     * 根据id获取文章详情
     * @param id
     * @return
     */
    ResponseResult getArticleDetail(Long id);

    /**
     * ②更新浏览量时去更新redis中的数据
     * @param id
     * @return
     */
    ResponseResult updateViewCount(Long id);

    /**
     * 添加博客(后台)
     * @param addArticleDto
     * @return
     */
    ResponseResult add(AddArticleDto addArticleDto);

    /**
     * 查询博客列表（后台）
     * @param article
     * @param pageNum
     * @param pageSize
     * @return
     */
    PageVo selectArticlePage(Article article, Integer pageNum, Integer pageSize);

    /**
     * 根据id查询要修改博客的信息——后台
     * @param id
     * @return
     */
    ArticleVo getInfo(Long id);

    /**
     * 修改博客——后台
     * @param articleDto
     * @return
     */
    void editArticle(ArticleDto articleDto);
}
