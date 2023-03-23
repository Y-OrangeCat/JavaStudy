package com.yang.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description: Tag数据传输对象——修改标签
 * @Author: Mr.Yang
 * @Date: 2023/3/2 23:43
 * @Version: 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EditTagDto {
    private Long id;
    //备注
    private String remark;
    //标签名
    private String name;
}
