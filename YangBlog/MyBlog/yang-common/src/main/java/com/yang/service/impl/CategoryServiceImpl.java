package com.yang.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yang.constants.SystemConstants;
import com.yang.domain.ResponseResult;
import com.yang.domain.entity.Article;
import com.yang.domain.entity.Category;
import com.yang.domain.vo.CategoryVo;
import com.yang.domain.vo.PageVo;
import com.yang.enums.AppHttpCodeEnum;
import com.yang.exception.SystemException;
import com.yang.mapper.CategoryMapper;
import com.yang.service.ArticleService;
import com.yang.service.CategoryService;
import com.yang.utils.BeanCopyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 分类表(Category)表服务实现类
 * @author makejava
 * @since 2022-12-04 19:44:23
 */
@Service("categoryService")
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {
    @Autowired
    private ArticleService articleService;

    /**
     * 查询分类列表
     * @return
     */
    @Override
    public ResponseResult getCategoryList() {
        //查询文章表  状态为已发布的文章
        LambdaQueryWrapper<Article> articleWrapper = new LambdaQueryWrapper<>();
        //查询文章为发布状态
        articleWrapper.eq(Article::getStatus, SystemConstants.ARTICLE_STATUS_NORMAL);
        List<Article> articleList = articleService.list(articleWrapper);
        //查询文章分类id,并去重
        Set<Long> categoryIds = articleList.stream()
                .map(Article::getCategoryId)
                .collect(Collectors.toSet());

        //查询分类表
        List<Category> categories = listByIds(categoryIds);
        categories.stream()
                .filter(category -> SystemConstants.STATUS_NORMAL.equals(category.getStatus()))
                .collect(Collectors.toList());

        //封装vo
        List<CategoryVo> categoryVos = BeanCopyUtils.copyBeanList(categories, CategoryVo.class);

        return ResponseResult.okResult(categoryVos);
    }

    /**
     * 写博客时显示分类列表——后台
     * @return
     */
    @Override
    public List<CategoryVo> listAllCategory() {
        LambdaQueryWrapper<Category> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Category::getStatus,SystemConstants.NORMAL);
        List<Category> categoryList = list(queryWrapper);
        //封装vo
        List<CategoryVo> categoryVos = BeanCopyUtils.copyBeanList(categoryList, CategoryVo.class);
        return categoryVos;
    }

    /**
     * 分页查询分类列表——后台
     */
    @Override
    public ResponseResult selectCategoryPage(Category category, Integer pageNum, Integer pageSize) {
        LambdaQueryWrapper<Category> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.like(StringUtils.hasText(category.getName()),Category::getName,category.getName());
        queryWrapper.eq(Objects.nonNull(category.getStatus()),Category::getStatus, category.getStatus());

        Page<Category> page = new Page<>();
        //设置第几页
        page.setCurrent(pageNum);
        //设置每页显示的数据量
        page.setSize(pageSize);
        page(page,queryWrapper);

        //封装Vo
        List<Category> categories = page.getRecords();
        PageVo pageVo = new PageVo();
        pageVo.setTotal(page.getTotal());//显示条数
        pageVo.setRows(categories);//对象数据列表

        return ResponseResult.okResult(pageVo);
    }

    /**
     * 添加判断存入的分类名是否唯一
     * 后台
     */
    @Override
    public boolean checkCategoryUnique(Category category) {
        LambdaQueryWrapper<Category> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Category::getName, category.getName());
        //结果集大于0，分类已存在
        return count(queryWrapper)>0;
    }

}

