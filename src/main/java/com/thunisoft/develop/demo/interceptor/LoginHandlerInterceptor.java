/**
 * @projectName DevelopDemo
 * @package com.thunisoft.develop.demo.interceptor
 * @className com.thunisoft.develop.demo.interceptor.LoginHandlerInterceptor
 * @copyright Copyright 2019 Thuisoft, Inc. All rights reserved.
 */
package com.thunisoft.develop.demo.interceptor;

import java.util.Objects;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

import com.thunisoft.develop.demo.entity.Users;

import lombok.extern.slf4j.Slf4j;

/**
 * LoginHandlerInterceptor
 *
 * @description 登录拦截器
 * @author taogl
 * @date 2019/12/3 10:11
 * @version v1.0.0
 */
@Slf4j
public class LoginHandlerInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
        throws Exception {
        Users user = (Users)request.getSession().getAttribute("user");
        if (Objects.isNull(user)) {
            response.sendRedirect("/login");
            return false;
        }
        return true;
    }
}
