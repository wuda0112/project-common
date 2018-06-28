package com.wuda.common.lang.web;

/**
 * 响应码.
 *
 * @author wuda
 */
public enum ResponseCode {

    /**
     * ok.
     */
    OK(200, "OK");
    /**
     * 响应码.
     */
    private int code;
    /**
     * 描述.
     */
    private String desc;

    ResponseCode(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}
