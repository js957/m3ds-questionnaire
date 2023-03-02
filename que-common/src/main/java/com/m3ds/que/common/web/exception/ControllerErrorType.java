package com.m3ds.que.common.web.exception;

import com.m3ds.que.common.core.exception.ErrorType;
import lombok.Getter;

@Getter
public enum ControllerErrorType implements ErrorType {

    FIELD_VERIFICATION_ERROR("1001", "字段校验不通过！");

    /**
     * 错误类型码
     */
    private String code;
    /**
     * 错误类型描述信息
     */
    private String msg;

    ControllerErrorType(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
