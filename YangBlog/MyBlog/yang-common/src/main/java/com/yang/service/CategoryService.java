package com.yang.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yang.domain.ResponseResult;
import com.yang.domain.entity.Category;
import com.yang.domain.vo.CategoryVo;

import java.util.List;

/**
 * 分类表(Category)表服务接口
 *
 * @author makejava
 * @since 2022-12-04 19:44:23
 */
public interface CategoryService extends IService<Category> {
    /**
     * 查询分类列表
     * @return
     */
    ResponseResult getCategoryList();



    /**
     * 写博客时显示分类列表（后端）
     * @return
     */
//    ResponseResult listAllCategory();
    List<CategoryVo> listAllCategory();

    /**
     * 分页查询分类列表
     */
    ResponseResult selectCategoryPage(Category category, Integer pageNum, Integer pageSize);


    /**
     * 判断存入的分类名是否唯一
     */
    boolean checkCategoryUnique(Category category);
}

