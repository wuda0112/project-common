package com.wuda.admin.db;

import lombok.Data;

import java.util.Map;

/**
 * 统一描述各种资源连接信息.比如:数据库连接,Redis连接等等.
 *
 * @author wuda
 */
@Data
public class ResourceConnectionInfo {

    /**
     * spring bean name.
     */
    private String springBeanName;
    /**
     * 对资源的简单描述,介绍.
     */
    private String desc;
    /**
     * 各变量的信息.
     */
    private Map<String, Object> variableMap;
}
