package com.m3ds.que.common.core.exception;

import lombok.Getter;

@Getter
public enum ResponseErrorType implements ErrorType{
    UNAUTHORIZED("401","登录状态过期"),
    NOT_FOUND("404","路径不存在，请检查路径是否正确"),
    SIGN_FAIL("405", "非法访问，请检查请求信息"),
    VALIDATE_FAIL("406", "验证失败。"),
    AUTHORIZATION_FAIL("407", "授权失败。"),
    REPEAT_INSERT("408", "数据库中已存在该记录"),
    NEED_VERIFICATION("416", "需要验证"),
    VALIDATE_CODE_FAIL("417", "验证码验证失败"),
    FAIL("500","")
    ;


    /**
     * 错误类型码
     */
    private String code;
    /**
     * 错误类型描述信息
     */
    private String msg;

    ResponseErrorType(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
