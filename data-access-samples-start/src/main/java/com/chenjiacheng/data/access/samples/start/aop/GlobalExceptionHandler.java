package com.chenjiacheng.data.access.samples.start.aop;

import com.chenjiacheng.data.access.samples.common.model.Result;
import com.chenjiacheng.data.access.samples.common.exception.BusinessException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理器
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 处理业务异常
     *
     * @param ex 业务异常
     * @return 统一结果
     */
    @ExceptionHandler(BusinessException.class)
    public Result<Void> handleBusinessException(BusinessException ex) {
        return Result.failure(ex.getCode(), ex.getMessage());
    }

    /**
     * 处理其他异常
     *
     * @param ex 未知异常
     * @return 统一结果
     */
    @ExceptionHandler(Exception.class)
    public Result<Void> handleException(Exception ex) {
        return Result.failure(500, "系统内部错误: " + ex.getMessage());
    }
}