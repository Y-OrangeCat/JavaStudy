package com.yang.controller;

import com.yang.domain.ResponseResult;
import com.yang.service.ArticleService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * @Description: 文章表实现类
 * @Author: Mr.Yang
 * @Date: 2022/11/22 20:38
 * @Version: 1.0
 */
@Api
@RestController
@RequestMapping("article")
public class ArticleController {
    @Autowired
    private ArticleService articleService;

//    @GetMapping("list")
//    public List<Article> test(){
//        return articleService.list();
//    }

    /**
     * 查询热门文章列表  localhost:7777/article/hotArticleList
     * @return
     */

    @GetMapping("/hotArticleList")
    public ResponseResult hotArticleList() {
        ResponseResult result = articleService.hotArticleList();
        return result;
    }

    /**
     * 查询分类文章列表   localhost:7777/article/articleList
     * @param pageNum
     * @param pageSize
     * @param categoryId
     * @return
     */
    @GetMapping("/articleList")
    public ResponseResult articleList(Integer pageNum, Integer pageSize, Long categoryId) {
        return articleService.articleList(pageNum, pageSize, categoryId);
    }

    /**
     * 根据id获取文章详情   localhost:7777/article/1
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public ResponseResult getArticleDetail(@PathVariable("id") Long id) {
        return articleService.getArticleDetail(id);
    }

    /**
     * ②更新浏览量时去更新redis中的数据
     * @param id
     * @return
     */
    @PutMapping("/updateViewCount/{id}")
    public ResponseResult updateViewCount(@PathVariable("id") Long id){
        return articleService.updateViewCount(id);
    }



}
