/**
 * @projectName DevelopDemo
 * @package com.thunisoft.develop.demo.schedule
 * @className com.thunisoft.develop.demo.schedule.ScheduleJob
 * @copyright Copyright 2019 Thuisoft, Inc. All rights reserved.
 */
package com.thunisoft.develop.demo.schedule;

import java.time.LocalDateTime;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

/**
 * ScheduleJob
 *
 * @description 定时任务
 * @author taogl
 * @date 2019/12/3 21:37
 * @version v1.0.0
 */
@Component
@Slf4j
public class ScheduleJob {

    /**
     * 按照标准时间来算，每隔 10s 执行一次
     */
    @Scheduled(cron = "0/10 * * * * ?")
    public void job1() {
        log.info("【job1】开始执行：{}", LocalDateTime.now());
    }

    /**
     * 从启动时间开始，间隔 2s 执行
     * 固定间隔时间
     */
    @Scheduled(fixedRate = 2000)
    public void job2() {
        log.info("【job2】开始执行：{}", LocalDateTime.now());
    }

    /**
     * 从启动时间开始，延迟 5s 后间隔 4s 执行
     * 固定等待时间
     */
    @Scheduled(fixedDelay = 4000, initialDelay = 5000)
    public void job3() {
        log.info("【job3】开始执行：{}", LocalDateTime.now());
    }
}