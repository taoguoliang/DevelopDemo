/**
 * @projectName DevelopDemo
 * @package com.thunisoft.develop.demo.config
 * @className com.thunisoft.develop.demo.config.ScheduleTaskConfig
 * @copyright Copyright 2019 Thuisoft, Inc. All rights reserved.
 */
package com.thunisoft.develop.demo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

import lombok.extern.slf4j.Slf4j;

/**
 * ScheduleTaskConfig
 *
 * @description 定时任务配置
 * @author taogl
 * @date 2019/12/3 21:33
 * @version v1.0.0
 */
@Configuration
@EnableScheduling
@Slf4j
public class ScheduleTaskConfig implements SchedulingConfigurer {

    @Value("${schedule.thread.pool.size: 20}")
    private int poolSize;

    @Value("${schedule.thread.pool.timeout: 60}")
    private int awaitTerminationSecond;

    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        taskRegistrar.setScheduler(threadPoolTaskScheduler());
    }

    /**
     * ScheduleTaskConfig
     *
     * @description 定时任务线程池配置
     * @return ThreadPoolTaskScheduler
     * @author taogl
     * @date 2019/12/3 21:34
     * @version v1.0.0
     **/
    @Bean
    public ThreadPoolTaskScheduler threadPoolTaskScheduler() {
        log.info("创建定时任务调度线程池 start");
        ThreadPoolTaskScheduler threadPoolTaskScheduler = new ThreadPoolTaskScheduler();
        threadPoolTaskScheduler.setPoolSize(poolSize);
        threadPoolTaskScheduler.setThreadNamePrefix("taskExecutor-");
        threadPoolTaskScheduler.setWaitForTasksToCompleteOnShutdown(true);
        threadPoolTaskScheduler.setAwaitTerminationSeconds(awaitTerminationSecond);
        log.info("创建定时任务调度线程池 end");
        return threadPoolTaskScheduler;
    }
}