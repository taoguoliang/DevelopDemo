/**
 * @projectName sfxz_zfjdpt_ksxt
 * @package com.thunisoft.sfxz.zfjdpt.ksxt.timer.bean
 * @className com.thunisoft.sfxz.zfjdpt.ksxt.timer.bean.ExamInfoScheduledTask
 * @copyright Copyright 2019 Thuisoft, Inc. All rights reserved.
 */
package com.thunisoft.develop.demo.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * 
 * ScheduledTask
 *
 * @description 定时任务实体
 * @author taogl
 * @date 2019年12月02日 15:33
 * @version 1.0
 */
@Getter
@Setter
@Accessors(chain = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "t_schedule", schema = "db_tgl")
public class ScheduledTask implements Serializable {
    private static final long serialVersionUID = 1L;

    /** 任务类型 */
    @Column(name="n_rwlx")
    private Integer rwlx;

    /** 任务描述 */
    @Size(max=300)
    @Column(name="c_rwms")
    private String rwms;

    /** 业务编号 */
    @Size(max=32)
    @Column(name="c_ywbh")
    private String ywbh;

    /** 任务开始时间 */
    @Column(name="dt_rwkssj")
    private LocalDateTime rwkssj;

    /** 是否启动 */
    @Column(name="n_sfqd")
    private Integer sfqd;

    /** 主键 */
    @NotBlank
    @Size(max=32)
    @Id
    @Column(name="c_bh")
    private String bh;

    /** 创建单位 */
    @Size(max=300)
    @Column(name="c_cjdw")
    private String cjdw;

    /** 是否有效 */
    @Column(name="n_sfyx")
    private Integer sfyx;

    /** 创建人编号 */
    @Size(max=300)
    @Column(name="c_cjr")
    private String cjr;

    /** 更新人编号 */
    @Size(max=300)
    @Column(name="c_gxr")
    private String gxr;

    /** 创建时间 */
    @Column(name="dt_cjsj")
    @CreatedDate
    private LocalDateTime cjsj;

    /** 更新时间 */
    @Column(name="dt_gxsj")
    @LastModifiedDate
    private LocalDateTime gxsj;

}
