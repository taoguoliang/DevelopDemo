/**
 * @projectName DevelopDemo
 * @package com.thunisoft.develop.demo.advice
 * @className com.thunisoft.develop.demo.advice.ApiResponse
 * @copyright Copyright 2019 Thuisoft, Inc. All rights reserved.
 */
package com.thunisoft.develop.demo.advice;

import java.io.Serializable;

import lombok.Builder;
import lombok.Data;

/**
 * ApiResponse
 *
 * @description Api响应实体
 * @author taogl
 * @date 2019/12/1 16:37
 * @version v1.0.0
 */
@Data
@Builder
public class ApiResponse implements Serializable {
    private String code;
    private String message;
}
