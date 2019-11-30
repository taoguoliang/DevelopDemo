/**
 * @projectName DevelopDemo
 * @package com.thunisoft.develop.demo.advice
 * @className com.thunisoft.develop.demo.advice.GlobalExceptionHandler
 * @copyright Copyright 2019 Thuisoft, Inc. All rights reserved.
 */
package com.thunisoft.develop.demo.advice;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * GlobalExceptionHandler
 *
 * @description 全局异常处理
 * @author taogl
 * @date 2019/11/27 21:10
 * @version v1.0.0
 */
@RestControllerAdvice
@Order(Ordered.LOWEST_PRECEDENCE-1)
public class GlobalExceptionHandler {

//    @ExceptionHandler(NoThisDataException.class)
//    public Exception
}
