package com.yang.domain.vo;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description: 博客分类导出表格Vo
 * @Author: Mr.Yang
 * @Date: 2023/3/5 15:55
 * @Version: 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExcelCategoryVo {

    @ExcelProperty("分类名")
    private String name;

    //描述
    @ExcelProperty("描述")
    private String description;

    //状态0:正常,1禁用
    @ExcelProperty("状态0:正常,1禁用")
    private String status;
}
