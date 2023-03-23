package com.yang.handler.security;

import com.alibaba.fastjson.JSON;
import com.yang.domain.ResponseResult;
import com.yang.enums.AppHttpCodeEnum;
import com.yang.utils.WebUtils;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Description: 认证失败处理器
 * @Author: Mr.Yang
 * @Date: 2023/1/7 0:12
 * @Version: 1.0
 */
@Component
public class AuthenticationEntryPointImpl implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException authException) throws IOException, ServletException {
        authException.printStackTrace();
        //InsufficientAuthenticationException 需要登陆授权
        //BadCredentialsException 登录信息错误
        ResponseResult result = null;
        if (authException instanceof BadCredentialsException) {
            result = ResponseResult.errorResult(AppHttpCodeEnum.LOGIN_ERROR.getCode(), authException.getMessage());
        } else if (authException instanceof InsufficientAuthenticationException) {
            result = ResponseResult.errorResult(AppHttpCodeEnum.NEED_LOGIN);
        } else {
            result = ResponseResult.errorResult(AppHttpCodeEnum.SYSTEM_ERROR.getCode(), "认证或授权失败！");
        }
//        ResponseResult result = ResponseResult.errorResult(AppHttpCodeEnum.LOGIN_ERROR);

        //相应给前端
        WebUtils.renderString(httpServletResponse, JSON.toJSONString(result));
    }
}
