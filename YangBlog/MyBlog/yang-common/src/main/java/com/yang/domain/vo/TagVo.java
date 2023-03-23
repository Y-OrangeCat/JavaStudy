package com.yang.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description: 查询标签列表Vo
 * @Author: Mr.Yang
 * @Date: 2023/3/3 16:05
 * @Version: 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TagVo {
    private Long id;

    //标签名
    private String name;
}
