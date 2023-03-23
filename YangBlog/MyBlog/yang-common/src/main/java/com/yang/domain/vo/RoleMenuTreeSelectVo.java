package com.yang.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * @Description:
 * @Author: Mr.Yang
 * @Date: 2023/3/8 15:56
 * @Version: 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class RoleMenuTreeSelectVo {
    private List<Long> checkedKeys;

    private List<MenuTreeVo> menus;
}
