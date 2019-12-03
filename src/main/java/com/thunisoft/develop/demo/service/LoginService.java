/**
 * @projectName DevelopDemo
 * @package com.thunisoft.develop.demo.service
 * @className com.thunisoft.develop.demo.service.LoginService
 * @copyright Copyright 2019 Thuisoft, Inc. All rights reserved.
 */
package com.thunisoft.develop.demo.service;

import java.util.Optional;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thunisoft.develop.demo.dto.LoginDTO;
import com.thunisoft.develop.demo.entity.Users;
import com.thunisoft.develop.demo.exception.LoginException;

/**
 * LoginService
 *
 * @description 登录服务
 * @author taogl
 * @date 2019/12/3 10:47
 * @version v1.0.0
 */
@Service
public class LoginService {

    @Autowired
    private UserService userService;

    /**
     * LoginService
     *
     * @description 登录
     * @param loginDTO 登录DTO
     * @return Users
     * @author taogl
     * @date 2019/12/3 10:55
     * @version v1.0.0
     **/
    public Users login(LoginDTO loginDTO) {
        return Optional.ofNullable(
            userService.getUserByLoginIdAndPassword(loginDTO.getLoginId(), DigestUtils.md5Hex(loginDTO.getPassword())))
            .orElseThrow(LoginException::new);
    }
}
