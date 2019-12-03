/**
 * @projectName DevelopDemo
 * @package com.thunisoft.develop.demo.repository
 * @className com.thunisoft.develop.demo.repository.UserRepository
 * @copyright Copyright 2019 Thuisoft, Inc. All rights reserved.
 */
package com.thunisoft.develop.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.thunisoft.develop.demo.entity.Users;

/**
 * UserRepository
 *
 * @description 用户repository
 * @author taogl
 * @date 2019/11/27 19:46
 * @version v1.0.0
 */
public interface UserRepository extends JpaRepository<Users, String> {

    /**
     * UserRepository
     *
     * @description 根据loginId和密码获取用户
     * @param loginId 登录名
     * @return 用户
     * @author taogl
     * @date 2019/12/3 10:49
     * @version v1.0.0
     **/
    Users getByLoginIdEqualsAndPasswordEquals(String loginId, String password);
}
