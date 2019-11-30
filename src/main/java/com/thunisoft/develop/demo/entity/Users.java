/**
 * @projectName DevelopDemo
 * @package com.thunisoft.develop.demo.entity
 * @className com.thunisoft.develop.demo.entity.Users
 * @copyright Copyright 2019 Thuisoft, Inc. All rights reserved.
 */
package com.thunisoft.develop.demo.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

/**
 * Users
 *
 * @description 用户实体
 * @author taogl
 * @date 2019/11/27 19:33
 * @version v1.0.0
 */
@Entity
@Table(name = "t_user", schema = "db_tgl")
@Data
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"hibernateLazyInitializer"})
public class Users implements Serializable {

    @Column(name = "c_bh")
    @Id
    @GeneratedValue(generator = "idGenerator")
    @GenericGenerator(name = "idGenerator", strategy = "uuid")
    private String id;

    @Column(name = "c_login_id")
    private String loginId;

    @Column(name = "c_user_name")
    private String userName;

    @Column(name = "c_password")
    private String password;

    @Column(name = "dt_create_time")
    @CreatedDate
    private LocalDateTime createTime;

    @Column(name = "dt_update_time")
    @LastModifiedDate
    private LocalDateTime updateTime;

    @Column(name = "c_create_user")
    private String createUser;

    @Column(name = "c_update_user")
    private String updateUser;
}
