/**
 * @projectName DevelopDemo
 * @package com.thunisoft.develop.demo.service
 * @className com.thunisoft.develop.demo.service.UserService
 * @copyright Copyright 2019 Thuisoft, Inc. All rights reserved.
 */
package com.thunisoft.develop.demo.service;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.thunisoft.develop.demo.dto.UserDTO;
import com.thunisoft.develop.demo.entity.Users;
import com.thunisoft.develop.demo.repository.UserRepository;

/**
 * UserService
 *
 * @description 用户服务
 * @author taogl
 * @date 2019/11/27 19:47
 * @version v1.0.0
 */
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    /**
     * UserService
     *
     * @description 新增用户
     * @param userDTO 用户dto
     * @author taogl
     * @date 2019/11/27 19:49
     * @version v1.0.0
     **/
    public void insertUser(UserDTO userDTO) {
        Users users = new Users();
        BeanUtils.copyProperties(userDTO, users);
        userRepository.save(users);
    }

    /**
     * UserService
     *
     * @description 根据userId获取User
     * @param userId 用户id
     * @return 用户
     * @author taogl
     * @date 2019/11/27 20:23
     * @version v1.0.0
     **/
    @Cacheable(value = "users", key = "#userId", condition = "#result != null")
    public Optional<Users> getUserById(String userId) {
        return userRepository.findById(userId);
    }
}
