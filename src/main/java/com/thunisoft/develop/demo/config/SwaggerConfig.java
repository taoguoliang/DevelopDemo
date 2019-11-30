/**
 * @projectName DevelopDemo
 * @package com.thunisoft.develop.demo.config
 * @className com.thunisoft.develop.demo.config.SwaggerConfig
 * @copyright Copyright 2019 Thuisoft, Inc. All rights reserved.
 */
package com.thunisoft.develop.demo.config;

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
 * SwaggerConfig
 *
 * @description swagger配置类
 * @author taogl
 * @date 2019/11/26 21:03
 * @version v1.0.0
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    /**
     * SwaggerConfig
     *
     * @description swagger开启
     * @return Docket
     * @author taogl
     * @date 2019/11/26 21:07
     * @version v1.0.0
     **/
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
            .apiInfo(apiInfo())
            .select()
            .apis(RequestHandlerSelectors.basePackage("com.thunisoft.develop.demo.controller"))
            .paths(PathSelectors.any())
            .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("Demo API文档")
            .description("开发环境Demo")
            .version("1.0.0")
            .build();
    }
}
