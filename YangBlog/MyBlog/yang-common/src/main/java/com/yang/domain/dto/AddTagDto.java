package com.yang.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description: Tag数据传输对象——新增标签
 * @Author: Mr.Yang
 * @Date: 2023/3/2 23:19
 * @Version: 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddTagDto {
    //标签名
    private String name;

    //备注
    private String remark;
}
