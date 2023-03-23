package com.yang.controller;

import com.alibaba.excel.EasyExcel;
import com.alibaba.fastjson.JSON;
import com.yang.constants.SystemConstants;
import com.yang.domain.ResponseResult;
import com.yang.domain.entity.Category;
import com.yang.domain.vo.CategoryVo;
import com.yang.domain.vo.ExcelCategoryVo;
import com.yang.enums.AppHttpCodeEnum;
import com.yang.service.CategoryService;
import com.yang.utils.BeanCopyUtils;
import com.yang.utils.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * @Description: 文章分类控制层(后端)
 * @Author: Mr.Yang
 * @Date: 2023/3/3 22:33
 * @Version: 1.0
 */
@RestController
@RequestMapping("/content/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    /**
     * 写博客时显示分类列表（后端）
     * @return
     */
    @GetMapping("/listAllCategory")
    public ResponseResult listAllCategory() {
        List<CategoryVo> categoryList = categoryService.listAllCategory();
        return ResponseResult.okResult(categoryList);
    }

    /**
     * 导出博客分类表
     * @param response
     */
    @PreAuthorize("@ps.hasPermission('content:category:export')")
    @GetMapping("/export")
    public void export(HttpServletResponse response) {
        try {
            //设置下载文件的请求头
            WebUtils.setDownLoadHeader("分类.xlsx", response);
            //获取需要导出的数据
            List<CategoryVo> categoryVos = categoryService.listAllCategory();
            List<ExcelCategoryVo> excelCategoryVos = BeanCopyUtils.copyBeanList(categoryVos, ExcelCategoryVo.class);
            //把数据写入到Excel中
            EasyExcel.write(response.getOutputStream(), ExcelCategoryVo.class).autoCloseStream(Boolean.FALSE).sheet("分类导出")
                    .doWrite(excelCategoryVos);
        } catch (Exception e) {
            //如果出现异常也要响应json
            ResponseResult result = ResponseResult.errorResult(AppHttpCodeEnum.SYSTEM_ERROR);
            WebUtils.renderString(response, JSON.toJSONString(result));
        }
    }

    /**
     * 分页查询分类列表
     */
    @GetMapping("/list")
    public ResponseResult CategoryList(Category category,Integer pageNum,Integer pageSize){
        return categoryService.selectCategoryPage(category,pageNum,pageSize);
    }

    /**
     * 添加分类
     * @param category
     * @return
     */
    @PostMapping
    public ResponseResult addCategory(@RequestBody Category category){
        //判断存入的分类名是否唯一
        if (categoryService.checkCategoryUnique(category)){
            return ResponseResult.errorResult(500,"分类名：" + category.getName() + "已存在！");
        }
        categoryService.save(category);
        return ResponseResult.okResult();
    }

    /**
     * 修改前获取分类信息
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public ResponseResult getInfoById(@PathVariable Long id){
        Category category = categoryService.getById(id);
        return ResponseResult.okResult(category);
    }

    /**
     * 修改分类
     * @return
     */
    @PutMapping
    public ResponseResult edit(@RequestBody Category category){
        categoryService.updateById(category);
        return ResponseResult.okResult();
    }

    /**
     * 删除分类
     */
    @DeleteMapping(value = "/{id}")
    public ResponseResult removeCategory(@PathVariable(value = "id") Long id){
        categoryService.removeById(id);
        return ResponseResult.okResult();
    }
}


