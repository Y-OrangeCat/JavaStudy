package com.yang.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description: 热门文章
 * @Author: Mr.Yang
 * @Date: 2022/12/3 23:05
 * @Version: 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class HotArticleVo {
    //id
    private Long id;
    //标题
    private String title;
    //访问量
    private Long viewCount;
}
