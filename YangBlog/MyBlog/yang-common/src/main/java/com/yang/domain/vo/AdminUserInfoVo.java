package com.yang.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * @Description: 后台用户信息Vo
 * @Author: Mr.Yang
 * @Date: 2023/2/23 21:19
 * @Version: 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class AdminUserInfoVo {
    private List<String> permission;

    private List<String> roles;

    private UserInfoVo user;

}
