/**
 * @projectName DevelopDemo
 * @package com.thunisoft.develop.demo.exception
 * @className com.thunisoft.develop.demo.exception.NoThisDataException
 * @copyright Copyright 2019 Thuisoft, Inc. All rights reserved.
 */
package com.thunisoft.develop.demo.exception;
/**
 * NoThisDataException
 *
 * @description 无此项数据异常
 * @author taogl
 * @date 2019/11/27 21:12
 * @version v1.0.0
 */
public class NoThisDataException extends RuntimeException {

    /**
     * NoThisDataException
     *
     * @description 无此项数据异常
     * @param message 异常信息
     * @author taogl
     * @date 2019/11/27 21:13
     * @version v1.0.0
     **/
    public NoThisDataException(String message) {
        super(message);
    }

    /**
     * NoThisDataException
     *
     * @description 无此项数据异常
     * @author taogl
     * @date 2019/11/27 21:13
     * @version v1.0.0
     **/
    public NoThisDataException() {
        super();
    }
}
