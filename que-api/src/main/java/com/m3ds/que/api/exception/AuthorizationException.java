package com.m3ds.que.api.exception;


import com.m3ds.que.common.core.exception.BaseException;
import com.m3ds.que.common.core.exception.ResponseErrorType;

/**
 * @author : smalljop
 * @description : 授权异常
 * @create : 2020-11-27 14:37
 **/
public class AuthorizationException extends BaseException {
    public AuthorizationException(String msg) {
        super(ResponseErrorType.AUTHORIZATION_FAIL, msg);
    }
}
