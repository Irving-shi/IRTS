package com.irving.ir.common.api;

/**
 * @author irving
 * @date 2021/1/29
 */
public enum ResultCode implements IErrorCode {
    SUCCESS(200, "操作成功",true),
    FAILED(400, "操作失败",false),
    VALIDATE_FAILED(404, "参数检验失败",false),
    UNAUTHORIZED(401, "暂未登录或token不存在",false),
    FORBIDDEN(403, "token已经过期或无效",false);
    private long code;
    private String msg;
    private  boolean success;

    ResultCode(long code, String msg,boolean success) {
        this.code = code;
        this.msg = msg;
        this.success=success;
    }

    @Override
    public long getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return msg;
    }

    @Override
    public boolean getSuccess() {
        return success;
    }


}
