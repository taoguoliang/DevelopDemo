/**
 * @projectName sfxz_zfjdpt_ksxt
 * @package com.thunisoft.sfxz.zfjdpt.ksxt.timer.repository
 * @className com.thunisoft.sfxz.zfjdpt.ksxt.timer.repository.ScheduledTaskRepository
 * @copyright Copyright 2019 Thuisoft, Inc. All rights reserved.
 */
package com.thunisoft.develop.demo.repository;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.thunisoft.develop.demo.entity.ScheduledTask;

/**
 * ScheduledTaskRepository
 *
 * @description 定时任务查询
 * @author taogl
 * @date 2019/11/28 14:07
 * @version v1.0.0
 */
public interface ScheduledTaskRepository extends JpaRepository<ScheduledTask, Serializable> {

    /**
     * ScheduledTaskRepository
     *
     * @description 获取任务开始时间在参数之前的任务列表
     * @param time 时间
     * @return 超时任务列表
     * @author taogl
     * @date 2019/11/28 17:25
     * @version v1.0.0
     **/
    List<ScheduledTask> findAllByRwkssjBefore(LocalDateTime time);

    /**
     * ScheduledTaskRepository
     *
     * @description 获取任务开始时间在参数之后的任务列表
     * @param time 时间
     * @return 未超时任务列表
     * @author taogl
     * @date 2019/11/28 17:25
     * @version v1.0.0
     **/
    List<ScheduledTask> findAllByRwkssjAfter(LocalDateTime time);

    /**
     * ScheduledTaskRepository
     *
     * @description 根据业务编号按任务开始时间正序获取定时任务
     * @param ywbh 业务编号
     * @return 定时任务
     * @author taogl
     * @date 2019/11/29 16:17
     * @version v1.0.0
     **/
    List<ScheduledTask> findAllByYwbhEqualsOrderByRwkssjAsc(String ywbh);

    /**
     * ScheduledTaskRepository
     *
     * @description 获取开始时间和结束时间之间的定时任务
     * @param start 开始时间
     * @param end 结束时间
     * @return 定时任务列表
     * @author taogl
     * @date 2019/12/4 10:50
     * @version v1.0.0
     **/
    List<ScheduledTask> findAllByRwkssjBetween(LocalDateTime start, LocalDateTime end);
}
