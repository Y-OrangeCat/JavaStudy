package com.yang.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Description: 分页Vo
 * @Author: Mr.Yang
 * @Date: 2022/12/5 15:18
 * @Version: 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageVo {
    //分页对象列表
    private List rows;

    //分页行数（满足条件的行数）
    private Long total;
}
