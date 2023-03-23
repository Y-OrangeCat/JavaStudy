package com.yang.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description: 改变角色状态Dto——后台
 * @Author: Mr.Yang
 * @Date: 2023/3/8 12:29
 * @Version: 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChangeRoleStatusDto {
    private Long roleId;
    private String status;
}
