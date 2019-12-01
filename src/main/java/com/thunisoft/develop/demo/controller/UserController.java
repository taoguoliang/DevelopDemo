/**
 * @projectName DevelopDemo
 * @package com.thunisoft.develop.demo.controller
 * @className com.thunisoft.develop.demo.controller.UserController
 * @copyright Copyright 2019 Thuisoft, Inc. All rights reserved.
 */
package com.thunisoft.develop.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thunisoft.develop.demo.dto.UserDTO;
import com.thunisoft.develop.demo.entity.Users;
import com.thunisoft.develop.demo.exception.NoThisDataException;
import com.thunisoft.develop.demo.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * UserController
 *
 * @author taogl
 * @version v1.0.0
 * @description 用户控制器
 * @date 2019/11/27 19:42
 */
@RestController
@RequestMapping("api/v1/users")
@Api(tags = "用户控制器")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * UserController
     *
     * @param userDTO 用户dto
     * @description 新增用户
     * @author taogl
     * @date 2019/11/27 19:45
     * @version v1.0.0
     **/
    @PostMapping
    @ApiOperation("新增用户")
    public void insert(UserDTO userDTO) {
        userService.insertUser(userDTO);
    }

    /**
     * UserController
     *
     * @param userId 用户id
     * @description 获取一个用户
     * @author taogl
     * @date 2019/11/27 19:45
     * @version v1.0.0
     **/
    @GetMapping
    @ApiOperation("获取用户")
    public Users getUserByUserId(String userId) {
        return userService.getUserById(userId).orElseThrow(() -> new NoThisDataException("找不到人员"));
    }
}
