package com.wuda.common.lang.web;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * 给客户端的响应结果.
 *
 * @param <T>
 *         响应中实际结果的类型
 * @author wuda
 */
@Getter
@Setter
@ToString
public class Response<T extends Vo> implements Serializable {

    /**
     * 响应码.
     */
    private ResponseCode responseCode;
    /**
     * 返回实际结果.
     */
    private T content;
}
