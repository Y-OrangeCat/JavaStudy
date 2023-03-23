package com.yang.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description: LinkVo
 * @Author: Mr.Yang
 * @Date: 2022/12/7 21:51
 * @Version: 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LinkVo {

    private Long id;

    private String name;

    private String logo;
    //
    private String description;
    //网站地址
    private String address;
}