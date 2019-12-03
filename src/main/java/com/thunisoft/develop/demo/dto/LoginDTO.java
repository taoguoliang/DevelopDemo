/**
 * @projectName DevelopDemo
 * @package com.thunisoft.develop.demo.dto
 * @className com.thunisoft.develop.demo.dto.LoginDTO
 * @copyright Copyright 2019 Thuisoft, Inc. All rights reserved.
 */
package com.thunisoft.develop.demo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * LoginDTO
 *
 * @description 登录DTO
 * @author taogl
 * @date 2019/12/3 10:42
 * @version v1.0.0
 */
@Data
@ApiModel(value = "登录DTO")
public class LoginDTO {

    @ApiModelProperty("登录id")
    private String loginId;

    @ApiModelProperty("密码")
    private String password;
}
