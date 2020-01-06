/**
 * @projectName DevelopDemo
 * @package com.thunisoft.develop.demo.config
 * @className com.thunisoft.develop.demo.config.WebConfig
 * @copyright Copyright 2019 Thuisoft, Inc. All rights reserved.
 */
package com.thunisoft.develop.demo.config;

import org.apache.commons.lang3.StringUtils;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.thunisoft.develop.demo.interceptor.LoginHandlerInterceptor;

import lombok.Setter;

/**
 * WebConfig
 *
 * @description 拦截配置
 * @author taogl
 * @date 2019/12/3 10:14
 * @version v1.0.0
 */
@Configuration
@PropertySource(value = "path.properties", encoding = "UTF-8")
@ConfigurationProperties(prefix = "path.filter")
@Setter
public class WebConfig implements WebMvcConfigurer {

    /** 不需要认证的地址 */
    private String anon;

    /**
     * WebConfig
     *
     * @description 注入登录拦截器
     * @return 登录拦截器bean
     * @author taogl
     * @date 2019/12/3 10:26
     * @version v1.0.0
     **/
    @Bean
    public LoginHandlerInterceptor getLoginHandlerInterceptor() {
        return new LoginHandlerInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(getLoginHandlerInterceptor()).addPathPatterns("/**")
            .excludePathPatterns(StringUtils.split(anon, ","));
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
    }
}
