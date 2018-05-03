package com.wuda.common.lang.web;

import lombok.Getter;
import lombok.Setter;

/**
 * 给客户端的响应结果.
 *
 * @param <T>
 *         响应中实际结果的类型
 */
@Getter
@Setter
public class Response<T extends Vo> {

    private ResponseCode responseCode; // 响应码
    private T content; // 返回实际结果

    /**
     * 生成响应实体.
     *
     * @param responseCode
     *         响应码
     * @param content
     *         实际响应内容
     */
    public Response(ResponseCode responseCode, T content) {
        this.responseCode = responseCode;
        this.content = content;
    }
}
