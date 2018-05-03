package com.wuda.common.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 核心配置内容.
 */
@Component
@ConfigurationProperties(prefix = CoreProperty.prefix)
public class CoreProperty {

    public final static String prefix = "core";

    /**
     * the copyright.
     */
    private String copyright;

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }
}
