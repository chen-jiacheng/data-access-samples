package com.chenjiacheng.data.access.samples.common.exception;

import com.chenjiacheng.data.access.samples.common.enums.BusinessCodeEnum;

/**
 * 业务异常类，用于处理业务逻辑中的错误
 */
public class BusinessException extends RuntimeException {

    private final int code;

    public BusinessException(BusinessCodeEnum businessCode) {
        super(businessCode.getMessage());
        this.code = businessCode.getCode();
    }

    public BusinessException(int code, String message) {
        super(message);
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}