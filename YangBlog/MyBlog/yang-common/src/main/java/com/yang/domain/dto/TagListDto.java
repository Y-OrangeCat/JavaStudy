package com.yang.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description: Tag数据传输对象
 * @Author: Mr.Yang
 * @Date: 2023/2/26 22:51
 * @Version: 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TagListDto {
    private Long id;
    private String name;
    private String remark;
}
