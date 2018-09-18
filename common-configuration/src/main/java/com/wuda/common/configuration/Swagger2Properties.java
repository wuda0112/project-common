package com.wuda.common.configuration;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * swagger2 属性信息.
 *
 * @author wuda
 */
@Getter
@Setter
@ToString
@Component
@ConfigurationProperties(prefix = "swagger2")
public class Swagger2Properties {

    private String basePackage;
    private String title;
    private String description;
}
