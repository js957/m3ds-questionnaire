package com.m3ds.que.common.core.exception;

import com.m3ds.que.common.core.exception.BaseException;
import com.m3ds.que.common.core.exception.ErrorType;
import com.m3ds.que.common.core.exception.ResponseErrorType;
import com.m3ds.que.common.web.exception.ControllerErrorType;

/**
 * Created by wjs on 2023/06/14
 */
public class ValidateFieldException extends BaseException {
    public ValidateFieldException(String msg) {
        super(ControllerErrorType.FIELD_VERIFICATION_ERROR, msg);
    }
}
