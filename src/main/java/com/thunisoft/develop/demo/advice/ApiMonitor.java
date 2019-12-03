/**
 * @projectName DevelopDemo
 * @package com.thunisoft.develop.demo.advice
 * @className com.thunisoft.develop.demo.advice.ApiMonitor
 * @copyright Copyright 2019 Thuisoft, Inc. All rights reserved.
 */
package com.thunisoft.develop.demo.advice;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

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
        assert attributes != null;
        HttpServletRequest request = attributes.getRequest();

        long start = System.currentTimeMillis();
        Object object = joinPoint.proceed();
        long end = System.currentTimeMillis();
        long takeTime = end - start;
        String methodName = joinPoint.getSignature().getName();

        log.info("---方法名是:{}, 接口:{}, 请求耗时是: {}ms---", methodName, request.getRequestURI(), takeTime);
        return object;
    }
}
