package com.yang.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description: 博客登录vo
 * @Author: Mr.Yang
 * @Date: 2022/12/24 23:12
 * @Version: 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BlogUserLoginVo {
    private String token;
    private UserInfoVo userInfo;

}
