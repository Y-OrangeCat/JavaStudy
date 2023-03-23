package com.yang.exception;

import com.yang.enums.AppHttpCodeEnum;

/**
 * @Description:
 * @Author: Mr.Yang
 * @Date: 2023/1/8 21:37
 * @Version: 1.0
 */
public class SystemException extends RuntimeException {
    private int code;
    private String msg;

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public SystemException(AppHttpCodeEnum httpCodeEnum) {
        super(httpCodeEnum.getMsg());
        this.code = httpCodeEnum.getCode();
        this.msg = httpCodeEnum.getMsg();
    }
}
