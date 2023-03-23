package com.yang.domain.vo;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * @Description: 博客登录vo
 * @Author: Mr.Yang
 * @Date: 2022/12/24 23:12
 * @Version: 1.0
 */
@AllArgsConstructor
@NoArgsConstructor
public class BlogUserLoginVo {
    private String token;
    private UserInfoVo userInfo;

    public String getToken() {
        return this.token;
    }

    public UserInfoVo getUserInfo() {
        return this.userInfo;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void setUserInfo(UserInfoVo userInfo) {
        this.userInfo = userInfo;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof BlogUserLoginVo)) return false;
        final BlogUserLoginVo other = (BlogUserLoginVo) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$token = this.getToken();
        final Object other$token = other.getToken();
        if (this$token == null ? other$token != null : !this$token.equals(other$token)) return false;
        final Object this$userInfo = this.getUserInfo();
        final Object other$userInfo = other.getUserInfo();
        if (this$userInfo == null ? other$userInfo != null : !this$userInfo.equals(other$userInfo)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof BlogUserLoginVo;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $token = this.getToken();
        result = result * PRIME + ($token == null ? 43 : $token.hashCode());
        final Object $userInfo = this.getUserInfo();
        result = result * PRIME + ($userInfo == null ? 43 : $userInfo.hashCode());
        return result;
    }

    public String toString() {
        return "BlogUserLoginVo(token=" + this.getToken() + ", userInfo=" + this.getUserInfo() + ")";
    }
}
