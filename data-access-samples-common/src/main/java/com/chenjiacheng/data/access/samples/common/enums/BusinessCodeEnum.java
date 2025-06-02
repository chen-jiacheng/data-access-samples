package com.chenjiacheng.data.access.samples.common.enums;

/**
 * 业务码枚举，定义业务相关的错误码和描述
 */
public enum BusinessCodeEnum {

    OK(200, "ok"),
    USER_NOT_FOUND(404, "用户未找到"),
    INVALID_PARAMETER(400, "参数无效"),
    OPERATION_FAILED(500, "操作失败");

    private final int code;
    private final String message;

    BusinessCodeEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}