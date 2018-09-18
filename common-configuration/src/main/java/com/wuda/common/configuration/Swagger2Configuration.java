package com.wuda.common.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * swagger2 配置信息.
 *
 * @author wuda
 */
@Configuration
@EnableSwagger2
public class Swagger2Configuration {

    private final Swagger2Properties swagger2Properties;

    @Autowired
    public Swagger2Configuration(Swagger2Properties swagger2Properties) {
        this.swagger2Properties = swagger2Properties;
    }

    @Bean
    public Docket docket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage(
                        swagger2Properties.getBasePackage() == null
                                ? "com.wuda.web" : swagger2Properties.getBasePackage()))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title(swagger2Properties.getTitle() == null
                        ? "API交互文档" : swagger2Properties.getTitle())
                .description(swagger2Properties.getDescription() == null
                        ? "swagger2 API 交互文档" : swagger2Properties.getDescription())
                .build();
    }

}
