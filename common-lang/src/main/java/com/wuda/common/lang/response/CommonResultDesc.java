package com.wuda.common.lang.response;

/**
 * 通用响应码.
 *
 * @author wuda
 */
public enum CommonResultDesc implements ResultDesc {

    /**
     * fail.
     */
    FAIL(0, "fail"),
    /**
     * ok.
     */
    OK(1, "ok");

    /**
     * 响应码.
     */
    private int code;
    /**
     * 描述.
     */
    private String message;

    CommonResultDesc(int code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public int getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
