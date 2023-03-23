package com.yang.handler.security;

import com.alibaba.fastjson.JSON;
import com.yang.domain.ResponseResult;
import com.yang.enums.AppHttpCodeEnum;
import com.yang.utils.JwtUtil;
import com.yang.utils.WebUtils;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Description: 授权失败处理器
 * @Author: Mr.Yang
 * @Date: 2023/1/7 0:27
 * @Version: 1.0
 */
@Component
public class AccessDeniedHandlerImpl implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AccessDeniedException e) throws IOException, ServletException {
        e.printStackTrace();
        ResponseResult result = ResponseResult.errorResult(AppHttpCodeEnum.NO_OPERATOR_AUTH);
        //相应给前端
        WebUtils.renderString(httpServletResponse, JSON.toJSONString(result));


    }
}
