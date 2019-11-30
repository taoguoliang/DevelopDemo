/**
 * @projectName DevelopDemo
 * @package com.thunisoft.develop.demo.dto
 * @className com.thunisoft.develop.demo.dto.UserDTO
 * @copyright Copyright 2019 Thuisoft, Inc. All rights reserved.
 */
package com.thunisoft.develop.demo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * UserDTO
 *
 * @description 用户DTO
 * @author taogl
 * @date 2019/11/27 19:43
 * @version v1.0.0
 */
@Data
@ApiModel
public class UserDTO {
    @ApiModelProperty("登录id")
    private String loginId;

    @ApiModelProperty("用户名")
    private String userName;

    @ApiModelProperty("密码")
    private String password;
}
