package com.wuda.common.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MapPropertySource;
import org.springframework.core.env.MutablePropertySources;

import java.util.HashMap;
import java.util.Map;

/**
 * 所有项目都会使用的核心配置信息.
 */
public class CoreConfigurationInitializer implements ApplicationContextInitializer {

    private static Logger logger = LoggerFactory.getLogger(CoreConfigurationInitializer.class);

    @Override
    public void initialize(ConfigurableApplicationContext configurableApplicationContext) {
        ConfigurableEnvironment environment = configurableApplicationContext.getEnvironment();
        MutablePropertySources propertySources = environment.getPropertySources();
        MapPropertySource mapPropertySource = configurationInfo();
        propertySources.addLast(mapPropertySource);// 如果本地有相同的配置项,则以本地为主
        logger.info("核心配置信息初始化完成.");
        logger.debug("核心配置信息内容:{}", mapPropertySource);
    }

    /**
     * 配置信息内容.
     *
     * @return MapPropertySource
     */
    private MapPropertySource configurationInfo() {
        String name = "core-configuration";
        Map<String, Object> map = new HashMap<>();
        map.put("core.copyright", "wuda");
        return new MapPropertySource(name, map);
    }
}
