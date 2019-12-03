/**
 * @projectName DevelopDemo
 * @package com.thunisoft.develop.demo.advice
 * @className com.thunisoft.develop.demo.advice.ApiMonitor
 * @copyright Copyright 2019 Thuisoft, Inc. All rights reserved.
 */
package com.thunisoft.develop.demo.advice;

import java.util.Map;
import java.util.Objects;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import eu.bitwalker.useragentutils.UserAgent;
import lombok.extern.slf4j.Slf4j;

/**
 * ApiMonitor
 *
 * @description Api监控
 * @author taogl
 * @date 2019/12/3 11:15
 * @version v1.0.0
 */
@Aspect
@Component
@Slf4j
public class ApiMonitor {

    /**
     * ApiMonitor
     *
     * @description 统计API接口调用耗时（方法调用的时间）
     * @param joinPoint 连接点
     * @return Object
     * @throws Throwable 异常
     * @author taogl
     * @date 2019/12/3 11:25
     * @version v1.0.0
     **/
    @Around("execution(public * com.thunisoft.develop.demo.controller.*.*(..))")
    public Object logServiceMethodAccess(ProceedingJoinPoint joinPoint) throws Throwable {
        // 接收到请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = Objects.requireNonNull(attributes).getRequest();

        log.info("【请求 URL】：{}", request.getRequestURL());
        log.info("【请求 IP】：{}", request.getRemoteAddr());
        log.info("【请求类名】：{}，【请求方法名】：{}", joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName());

        Map<String, String[]> parameterMap = request.getParameterMap();
        log.info("【请求参数】：{}，", parameterMap);

        long start = System.currentTimeMillis();
        Object object = joinPoint.proceed();
        long end = System.currentTimeMillis();

        log.info("【请求耗时】：{}毫秒", end - start);
        String header = request.getHeader("User-Agent");
        UserAgent userAgent = UserAgent.parseUserAgentString(header);
        log.info("【浏览器类型】：{}，【操作系统】：{}，【原始User-Agent】：{}", userAgent.getBrowser().toString(), userAgent.getOperatingSystem().toString(), header);

        return object;
    }
}
