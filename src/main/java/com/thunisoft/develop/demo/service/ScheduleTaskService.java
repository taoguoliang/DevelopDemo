/**
 * @projectName sfxz_zfjdpt_ksxt
 * @package com.thunisoft.sfxz.zfjdpt.ksxt.schedule.model
 * @className com.thunisoft.sfxz.zfjdpt.ksxt.schedule.model.ScheduleTaskServiceImpl
 * @copyright Copyright 2019 Thuisoft, Inc. All rights reserved.
 */
package com.thunisoft.develop.demo.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thunisoft.develop.demo.entity.ScheduledTask;
import com.thunisoft.develop.demo.repository.ScheduledTaskRepository;

/**
 * ScheduleTaskServiceImpl
 *
 * @description 定时任务查询基础服务
 * @author taogl
 * @date 2019/11/29 16:04
 * @version v1.0.0
 */
@Service
public class ScheduleTaskService {
    @Autowired
    private ScheduledTaskRepository scheduledTaskRepository;

    /**
     * @return the scheduledTaskRepository
     */
    public ScheduledTaskRepository getScheduledTaskRepository() {
        return scheduledTaskRepository;
    }

    /**
     * ScheduleTaskServiceImpl
     *
     * @description 获取所有超时的任务列表
     * @return 超时的任务列表
     * @author taogl
     * @date 2019/11/28 16:55
     * @version v1.0.0
     **/
    public List<ScheduledTask> getOverTimeTaskList() {
        return scheduledTaskRepository.findAllByRwkssjBefore(LocalDateTime.now());
    }

    /**
     * ScheduledTaskActionService
     *
     * @description 获取所有未超时的任务列表
     * @return 未超时的任务列表
     * @author taogl
     * @date 2019/11/28 16:55
     * @version v1.0.0
     **/
    public List<ScheduledTask> getInTimeTaskList() {
        return scheduledTaskRepository.findAllByRwkssjAfter(LocalDateTime.now());
    }

    /**
     * ScheduleTaskServiceImpl
     *
     * @description 根据业务编号获取定时任务Bean
     * @param businessId 业务编号
     * @return 定时任务Bean
     * @author taogl
     * @date 2019/11/29 16:18
     * @version v1.0.0
     **/
    public List<ScheduledTask> getScheduledTaskByBusinessIdAndTaskStartTimeAsc(String businessId) {
        return scheduledTaskRepository.findAllByYwbhEqualsOrderByRwkssjAsc(businessId);
    }

    /**
     * ScheduleTaskServiceImpl
     *
     * @description 获取当天定时任务
     * @return 定时任务Bean
     * @author taogl
     * @date 2019/11/29 16:18
     * @version v1.0.0
     **/
    public List<ScheduledTask> getScheduledTasksToday() {
        return scheduledTaskRepository.findAllByRwkssjBetween(LocalDateTime.of(LocalDate.now(), LocalTime.MIN),
            LocalDateTime.of(LocalDate.now(), LocalTime.MAX));
    }
}
