package com.yang.controller;

import com.yang.domain.ResponseResult;
import com.yang.domain.dto.AddArticleDto;
import com.yang.domain.dto.ArticleDto;
import com.yang.domain.entity.Article;
import com.yang.domain.vo.ArticleVo;
import com.yang.domain.vo.PageVo;
import com.yang.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Description: 博客文章控制层——后台
 * @Author: Mr.Yang
 * @Date: 2023/3/3 23:37
 * @Version: 1.0
 */
@RestController
@RequestMapping("/content/article")
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    /**
     * 添加博客
     *
     * @param addArticleDto
     * @return
     */
    @PostMapping
    public ResponseResult add(@RequestBody AddArticleDto addArticleDto) {
        return articleService.add(addArticleDto);
    }

    /**
     * 查询博客列表
     *
     * @param article
     * @param pageNum
     * @param pageSize
     * @return
     */
    @GetMapping("/list")
    public ResponseResult list(Article article, Integer pageNum, Integer pageSize) {
        PageVo pageVo = articleService.selectArticlePage(article, pageNum, pageSize);
        return ResponseResult.okResult(pageVo);
    }

    /**
     * 根据id查询要修改博客的信息——后台
     * @param id
     * @return
     */
    @GetMapping(value = "/{id}")
    public ResponseResult getInfo(@PathVariable(value = "id") Long id) {
        ArticleVo article = articleService.getInfo(id);
        return ResponseResult.okResult(article);
    }

    /**
     * 修改博客
     * @param articleDto
     * @return
     */
    @PutMapping
    public ResponseResult editArticle(@RequestBody ArticleDto articleDto){
        articleService.editArticle(articleDto);
        return ResponseResult.okResult();
    }


    @DeleteMapping("/{id}")
    public ResponseResult deleteArticle(@PathVariable Long id){
        articleService.removeById(id);
        return ResponseResult.okResult();
    }

}
