package com.yang.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description: 博客分类Vo
 * @Author: Mr.Yang
 * @Date: 2022/12/4 23:16
 * @Version: 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryVo {
    private Long id;
    private String name;
    //描述
    private String description;
}
