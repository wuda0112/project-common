package com.wuda.common.configuration;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 核心配置内容.
 *
 * @author wuda
 */
@Getter
@Setter
@Component
@ConfigurationProperties(prefix = "core")
public class CoreProperty {

    /**
     * the copyright.
     */
    private String copyright;
}
