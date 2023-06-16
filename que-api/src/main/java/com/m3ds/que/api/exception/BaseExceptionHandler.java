package com.m3ds.que.api.exception;

import cn.hutool.core.exceptions.ValidateException;
import com.m3ds.que.common.core.exception.ResponseErrorType;
import com.m3ds.que.common.core.exception.ValidateFieldException;
import com.m3ds.que.common.core.vo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

/**
 * 异常处理器
 *
 * @author smalljop
 */
@RestControllerAdvice
@Slf4j
public class BaseExceptionHandler {


    @ExceptionHandler(NoHandlerFoundException.class)
    public Result handlerNoFoundException(NoHandlerFoundException e) {
        log.error(e.getMessage(), e);
        return Result.fail(ResponseErrorType.NOT_FOUND);
    }


    @ExceptionHandler(AuthorizationException.class)
    public Result handlerAuthorizationException(AuthorizationException e) {
        log.error(e.getMessage(), e);
        return Result.fail(ResponseErrorType.UNAUTHORIZED);
    }


    @ExceptionHandler(DuplicateKeyException.class)
    public Result handleDuplicateKeyException(DuplicateKeyException e) {
        log.error(e.getMessage(), e);
        return Result.fail(ResponseErrorType.REPEAT_INSERT);
    }

    @ExceptionHandler({ValidateException.class})
    public Result handleValidateException(ValidateException e) {
        log.error(e.getMessage(), e);
        return Result.fail(e.getMessage());
    }

    @ResponseBody
    @ExceptionHandler(value = MissingServletRequestParameterException.class)
    public Object exceptionHandler(MissingServletRequestParameterException e) {
        log.error("System Exception:{}", e.getMessage());
        return Result.fail(e.getMessage());
    }

    @ResponseBody
    @ExceptionHandler(value = ValidateFieldException.class)
    public Object exceptionHandler(ValidateFieldException e) {
        log.error(e.getMessage(), e);
        return Result.fail(e.getMessage());
    }


    @ExceptionHandler(Exception.class)
    public Result handleException(Exception e) {
        log.error(e.getMessage(), e);
        return Result.fail(e.getMessage());
    }
}
