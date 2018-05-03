package com.wuda.common.lang.web;

/**
 * 响应码.
 */
public enum ResponseCode {

    OK(200, "OK");

    private int code;// 响应码
    private String desc;// 描述

    ResponseCode(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}
