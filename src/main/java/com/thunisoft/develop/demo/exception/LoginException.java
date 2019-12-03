/**
 * @projectName DevelopDemo
 * @package com.thunisoft.develop.demo.exception
 * @className com.thunisoft.develop.demo.exception.LoginException
 * @copyright Copyright 2019 Thuisoft, Inc. All rights reserved.
 */
package com.thunisoft.develop.demo.exception;
/**
 * LoginException
 *
 * @description 用户名或密码错误异常
 * @author taogl
 * @date 2019/12/3 10:44
 * @version v1.0.0
 */
public class LoginException extends RuntimeException {
    /**
     * LoginException
     *
     * @description 异常构造函数
     * @author taogl
     * @date 2019/12/3 10:45
     * @version v1.0.0
     **/
    public LoginException() {
        super("用户名或密码错误");
    }
}
