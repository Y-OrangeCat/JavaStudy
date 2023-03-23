package com.yang.handler.exception;

import com.yang.domain.ResponseResult;
import com.yang.enums.AppHttpCodeEnum;
import com.yang.exception.SystemException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @Description: 统一异常处理
 * @Author: Mr.Yang
 * @Date: 2023/1/8 21:49
 * @Version: 1.0
 */
@RestControllerAdvice
@Slf4j
public class GobalExceptionHandler {

    @ExceptionHandler(SystemException.class)
    public ResponseResult systemExceptionHandler(SystemException e) {
        //打印异常信息
         log.error("出现了异常! {}", e);
        //从异常信息中获取提示信息并封装返回
        return ResponseResult.errorResult(e.getCode(), e.getMsg());
    }

    @ExceptionHandler(Exception.class)
    public ResponseResult exceptionHandler(Exception e) {
        //打印异常信息
        log.error("出现了异常！ {}", e);
        //从异常信息中获取提示信息并封装返回
        return ResponseResult.errorResult(AppHttpCodeEnum.SYSTEM_ERROR.getCode(), e.getMessage());
    }
}
