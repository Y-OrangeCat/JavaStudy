package com.yang.domain.vo;

import com.yang.domain.entity.Menu;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Description: 后台用户菜单信息Vo
 * @Author: Mr.Yang
 * @Date: 2023/2/24 23:27
 * @Version: 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoutersVo {
    private List<Menu> menus;

}
