/**
 * @projectName DevelopDemo
 * @package com.thunisoft.develop.demo.advice
 * @className com.thunisoft.develop.demo.advice.GlobalExceptionHandler
 * @copyright Copyright 2019 Thuisoft, Inc. All rights reserved.
 */
package com.thunisoft.develop.demo.advice;

import javax.servlet.http.HttpServletRequest;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.HandlerMethod;

import com.thunisoft.develop.demo.exception.LoginException;
import com.thunisoft.develop.demo.exception.NoThisDataException;

import lombok.extern.slf4j.Slf4j;

/**
 * GlobalExceptionHandler
 *
 * @description 全局异常处理
 * @author taogl
 * @date 2019/11/27 21:10
 * @version v1.0.0
 */
@RestControllerAdvice
@Order(Ordered.LOWEST_PRECEDENCE - 1)
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(NoThisDataException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ApiResponse noThisDataException(HttpServletRequest req, Exception e, HandlerMethod method) {
        log.error("---资源未找到异常---method: {}, Host {} invokes url {} ERROR: {}", method.getMethod().getName(),
            req.getRemoteHost(), req.getRequestURL(), e.getMessage(), e);
        return ApiResponse.builder().message(e.getMessage()).build();
    }

    @ExceptionHandler(LoginException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ApiResponse loginException(HttpServletRequest req, Exception e, HandlerMethod method) {
        log.error("---登录系统异常---method: {}, Host {} invokes url {} ERROR: {}", method.getMethod().getName(),
            req.getRemoteHost(), req.getRequestURL(), e.getMessage(), e);
        return ApiResponse.builder().message(e.getMessage()).build();
    }
}
