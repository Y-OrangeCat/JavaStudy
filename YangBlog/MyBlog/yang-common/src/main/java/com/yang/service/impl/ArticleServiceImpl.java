package com.yang.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yang.constants.SystemConstants;
import com.yang.domain.ResponseResult;
import com.yang.domain.dto.AddArticleDto;
import com.yang.domain.dto.ArticleDto;
import com.yang.domain.entity.Article;
import com.yang.domain.entity.ArticleTag;
import com.yang.domain.entity.Category;
import com.yang.domain.vo.*;
import com.yang.mapper.ArticleMapper;
import com.yang.service.ArticleService;
import com.yang.service.ArticleTagService;
import com.yang.service.CategoryService;
import com.yang.utils.BeanCopyUtils;
import com.yang.utils.RedisCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @Description: 博客文章实现类
 * @Author: Mr.Yang
 * @Date: 2022/11/22 20:20
 * @Version: 1.0
 */
@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article> implements ArticleService {
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private RedisCache redisCache;
    @Autowired
    private ArticleTagService articleTagService;

    /**
     * 热门文章
     * @return
     */
    @Override
    public ResponseResult hotArticleList() {
        //查询热门文章 封装成ResponseResult返回
        LambdaQueryWrapper<Article> queryWrapper = new LambdaQueryWrapper<>();
        //必须是正式文章
        queryWrapper.eq(Article::getStatus, SystemConstants.ARTICLE_STATUS_NORMAL);
        //按照浏览量进行排序
        queryWrapper.orderByDesc(Article::getViewCount);
        //最多只查询10条
        Page<Article> page = new Page<>(1, 10);
        page(page, queryWrapper);

        List<Article> articles = page.getRecords();

        //bean拷贝
        List<HotArticleVo> articleVos = BeanCopyUtils.copyBeanList(articles, HotArticleVo.class);

        return ResponseResult.okResult(articleVos);
    }

    /**
     * 查询分类文章列表
     * @param pageNum    当前页
     * @param pageSize   条数
     * @param categoryId
     * @return
     */
    @Override
    public ResponseResult articleList(Integer pageNum, Integer pageSize, Long categoryId) {
        LambdaQueryWrapper<Article> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        // 如果 有categoryId 就要 查询时要和传入的相同
        lambdaQueryWrapper.eq(Objects.nonNull(categoryId) && categoryId > 0, Article::getCategoryId, categoryId);
        // 状态是正式发布的
        lambdaQueryWrapper.eq(Article::getStatus, SystemConstants.ARTICLE_STATUS_NORMAL);
        // 对isTop进行降序
        lambdaQueryWrapper.orderByDesc(Article::getIsTop);

        //分页查询
        Page<Article> page = new Page<>(pageNum, pageSize);
        //Params:page – 翻页对象; queryWrapper – 实体对象封装操作类
        page(page, lambdaQueryWrapper);
        //分页记录列表
        //Returns:分页对象记录列表
        List<Article> articleList = page.getRecords();
        //article:分类名 = 分类:名 = 根据id查分类 = article的分类id
        /*for (Article article : articleList) {
            Category category = categoryService.getById(article.getCategoryId());
            article.setCategoryName(category.getName());
        }*/
        articleList.stream()
                .map(article -> article.setCategoryName(categoryService.getById(article.getCategoryId()).getName()))
                .collect(Collectors.toList());


        //复制Bean,封装查询结果vo
        List<ArticleListVo> articleListVos = BeanCopyUtils.copyBeanList(page.getRecords(), ArticleListVo.class);
        //getTotal当前满足条件总行数
        PageVo pageVo = new PageVo(articleListVos, page.getTotal());

        return ResponseResult.okResult(pageVo);
    }

    /**
     * 根据id获取文章详情
     * @param id
     * @return
     */
    @Override
    public ResponseResult getArticleDetail(Long id) {
        //根据id获取文章
        Article article = getById(id);

        //从redis中获取浏览量
        Integer viewCount = redisCache.getCacheMapValue(SystemConstants.ARTICLE_VIEW_COUNT, id.toString());
        //设置到Article中
        article.setViewCount(viewCount.longValue());

        //封装vo
        ArticleDetailVo articleDetailVo = BeanCopyUtils.copyBean(article, ArticleDetailVo.class);
        //根据分类id查询分类名
        Long categoryId = articleDetailVo.getCategoryId();
        Category category = categoryService.getById(categoryId);
        //判断不为空
        if (category != null) {
            articleDetailVo.setCategoryName(category.getName());
        }
        //封装相应返回
        return ResponseResult.okResult(articleDetailVo);
    }

    /**
     * ②更新浏览量时去更新redis中的数据
     * @param id
     * @return
     */
    @Override
    public ResponseResult updateViewCount(Long id) {
        //更新数据到redis中
        redisCache.incrementCacheMapValue(SystemConstants.ARTICLE_VIEW_COUNT, id.toString(), 1);
        return ResponseResult.okResult();
    }

    /**
     * 添加博客(后台)
     * @param addArticleDto
     * @return
     */
    @Override
    @Transactional
    public ResponseResult add(AddArticleDto addArticleDto) {
        //添加博客
        Article article = BeanCopyUtils.copyBean(addArticleDto, Article.class);
        save(article);

        List<ArticleTag> articleTags = addArticleDto.getTags().stream()
                .map(tagId -> new ArticleTag(article.getId(), tagId))
                .collect(Collectors.toList());

        //添加 博客和标签的关联
        articleTagService.saveBatch(articleTags);
        return ResponseResult.okResult();
    }

    /**
     * 查询博客列表（后台）
     * @param article
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public PageVo selectArticlePage(Article article, Integer pageNum, Integer pageSize) {
        LambdaQueryWrapper<Article> queryWrapper = new LambdaQueryWrapper<>();
        //模糊查询，文章的标题以及摘要
        queryWrapper.like(StringUtils.hasText(article.getTitle()), Article::getTitle, article.getTitle());
        queryWrapper.like(StringUtils.hasText(article.getSummary()), Article::getSummary, article.getSummary());

        Page<Article> page = new Page<>();
        //设置当前页
        page.setCurrent(pageNum);
        //设置每页显示条数
        page.setSize(pageSize);
        //翻页查询 page – 翻页对象，queryWrapper – 实体对象封装操作类
        page(page, queryWrapper);

        //转换Vo
        //分页对象记录列表
        List<Article> articles = page.getRecords();

        PageVo pageVo = new PageVo();
        //设置当前满足条件总行数
        pageVo.setTotal(page.getTotal());
        //分页对象记录列表
        pageVo.setRows(articles);

        return pageVo;
    }

    /**
     * 根据id查询要修改博客的信息——后台
     * @param id
     * @return
     */
    @Override
    public ArticleVo getInfo(Long id) {
        Article article = getById(id);
        //获取关联标签
        LambdaQueryWrapper<ArticleTag> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(ArticleTag::getArticleId, article.getId());
        List<ArticleTag> articleTagList = articleTagService.list(queryWrapper);

        //使用stream流遍历标签列表
        List<Long> tags = articleTagList.stream().map(articleTag -> articleTag.getTagId())
                .collect(Collectors.toList());
        //封装Vo
        ArticleVo articleVo = BeanCopyUtils.copyBean(article, ArticleVo.class);
        //设置articleVo的标签
        articleVo.setTags(tags);

        return articleVo;
    }

    /**
     * 修改博客——后台
     * @param articleDto
     * @return
     */
    @Override
    public void editArticle(ArticleDto articleDto) {
        Article article = BeanCopyUtils.copyBean(articleDto, Article.class);
        //更新博客的信息
        updateById(article);
        //删除原有的 标签和博客的关联
        LambdaQueryWrapper<ArticleTag> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(ArticleTag::getArticleId,article.getId());
        articleTagService.remove(queryWrapper);
        //添加新的博客标签和关联信息
        List<ArticleTag> articleTags = articleDto.getTags().stream()
                .map(tagId -> new ArticleTag(articleDto.getId(), tagId))
                .collect(Collectors.toList());

        articleTagService.saveBatch(articleTags);
    }
}
