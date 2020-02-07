/**
 * @projectName sfxz_zfjdpt_ksxt
 * @package com.thunisoft.sfxz.zfjdpt.ksxt.timer
 * @className com.thunisoft.sfxz.zfjdpt.ksxt.timer.impl.ScheduledTaskActionServiceImpl
 * @copyright Copyright 2019 Thuisoft, Inc. All rights reserved.
 */
package com.thunisoft.develop.demo.service.impl;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.locks.ReentrantLock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.stereotype.Service;

import com.thunisoft.develop.demo.consts.CodeConsts;
import com.thunisoft.develop.demo.entity.ScheduledTask;
import com.thunisoft.develop.demo.exception.NoThisDataException;
import com.thunisoft.develop.demo.service.ScheduleTaskService;
import com.thunisoft.develop.demo.service.ScheduledTaskActionService;
import com.thunisoft.develop.demo.util.DateUtils;

import lombok.extern.slf4j.Slf4j;

/**
 * ScheduledTaskActionServiceImpl
 *
 * @description 定时任务实现
 * @author taogl
 * @date 2019/11/28 13:55
 * @version v1.0.0
 */
@Slf4j
@Service
public class ScheduledTaskActionServiceImpl implements ScheduledTaskActionService {
    
    private ReentrantLock lock = new ReentrantLock();

    /** 存放已经启动的任务map */
    private Map<String, ScheduledFuture> scheduledFutureMap = new ConcurrentHashMap<>(16);

    @Autowired
    private ScheduleTaskService scheduleTaskService;

    @Autowired
    private ThreadPoolTaskScheduler threadPoolTaskScheduler;

    @Override
    public boolean start(String taskId) {
        log.info("开启任务{}", taskId);
        lock.lock();
        try {
            // 校验是否已经启动
            if (isStart(taskId)) {
                log.info("当前任务已经启动，无需重复启动！");
                return false;
            }
            ScheduledTask scheduledTask = scheduleTaskService.getScheduledTaskRepository().findById(taskId)
                .orElseThrow(() -> new NoThisDataException("找不到该定时任务"));
            startTask(scheduledTask);
        } finally {
            lock.unlock();
            log.info("释放任务启动锁完毕");
        }
        return true;
    }

    @Override
    public void stop(String taskId) {
        log.info("停止任务 {}", taskId);
        // 当前任务实例是否存在
        boolean taskStartFlag = scheduledFutureMap.containsKey(taskId);
        if (taskStartFlag) {
            ScheduledFuture scheduledFuture = scheduledFutureMap.get(taskId);
            scheduledFuture.cancel(true);
            scheduledFutureMap.remove(taskId);
            updateDbScheduleStatusNotStart(taskId);
        }
    }

    private void updateDbScheduleStatusNotStart(String taskId) {
        ScheduledTask scheduledTask = scheduleTaskService.getScheduledTaskRepository().findById(taskId)
            .map(taskBean -> taskBean.setSfqd(CodeConsts.CODE_YES_NO_NO))
            .orElseThrow(() -> new NoThisDataException("找不到该定时任务"));
        scheduleTaskService.getScheduledTaskRepository().save(scheduledTask);
    }

    @Override
    public boolean restart(String taskId) {
        log.info("重启任务 {}", taskId);
        // 先停止,再启动
        stop(taskId);
        return start(taskId);
    }

    private void startTask(ScheduledTask scheduledTask) {
        log.info("准备启动定时任务[{}]:[{}]", scheduledTask.getBh(), scheduledTask.getRwms());
        ScheduledFuture scheduledFuture = threadPoolTaskScheduler
            .schedule(() -> log.info("{}----我执行了", LocalDateTime.now()), DateUtils.asDate(scheduledTask.getRwkssj()));
        scheduledFutureMap.put(scheduledTask.getBh(), scheduledFuture);
        // 更新任务状态
        scheduleTaskService.getScheduledTaskRepository().save(scheduledTask.setSfqd(CodeConsts.CODE_YES_NO_YES));
    }

    private boolean isStart(String taskKey) {
        // 校验是否已经启动
        if (scheduledFutureMap.containsKey(taskKey)) {
            return !scheduledFutureMap.get(taskKey).isCancelled();
        }
        return false;
    }

}