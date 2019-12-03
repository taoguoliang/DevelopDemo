/**
 * @projectName DevelopDemo
 * @package com.thunisoft.develop.demo.controller
 * @className com.thunisoft.develop.demo.controller.LoginController
 * @copyright Copyright 2019 Thuisoft, Inc. All rights reserved.
 */
package com.thunisoft.develop.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.thunisoft.develop.demo.dto.LoginDTO;
import com.thunisoft.develop.demo.service.LoginService;

/**
 * LoginController
 *
 * @description 登录控制器
 * @author taogl
 * @date 2019/11/26 21:17
 * @version v1.0.0
 */
@Controller
@RequestMapping
public class LoginController {

    @Autowired
    private LoginService loginService;

    /**
     * LoginController
     *
     * @description 登录
     * @param loginDTO 登录DTO
     * @author taogl
     * @date 2019/12/3 10:43
     * @version v1.0.0
     **/
    @PostMapping("/login")
    public void login(LoginDTO loginDTO) {
        loginService.login(loginDTO);
    }
}
