package com.m3ds.que.api.exception;

import com.m3ds.que.common.core.exception.BaseException;
import com.m3ds.que.common.core.exception.ErrorType;
import com.m3ds.que.common.core.exception.ResponseErrorType;

/**
 * @author : smalljop
 * @description : 验证码错误
 * @create : 2020-12-14 16:00
 **/
public class ValidateCodeException extends BaseException {
    public ValidateCodeException(String msg) {
        super(ResponseErrorType.VALIDATE_FAIL,msg);
    }
}
