package com.wuda.common.lang.response;

/**
 * 响应码.
 *
 * @author wuda
 */
public interface ResultDesc {

    /**
     * 获取状态码.
     *
     * @return 状态码
     */
    int getCode();

    /**
     * 获取描述信息.
     *
     * @return message
     */
    String getMessage();

}
