/**
 * @projectName DevelopDemo
 * @package com.thunisoft.develop.demo.config
 * @className com.thunisoft.develop.demo.config.WebConfig
 * @copyright Copyright 2019 Thuisoft, Inc. All rights reserved.
 */
package com.thunisoft.develop.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.thunisoft.develop.demo.interceptor.LoginHandlerInterceptor;

/**
 * WebConfig
 *
 * @description 拦截配置
 * @author taogl
 * @date 2019/12/3 10:14
 * @version v1.0.0
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

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
        registry.addInterceptor(getLoginHandlerInterceptor()).addPathPatterns("/**").excludePathPatterns("/login")
            .excludePathPatterns("/static/**");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
    }
}
