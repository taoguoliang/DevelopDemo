/**
 * @projectName sfxz_zfjdpt_ksxt
 * @package com.thunisoft.sfxz.zfjdpt.ksxt.timer
 * @className com.thunisoft.sfxz.zfjdpt.ksxt.timer.ScheduledTaskActionService
 * @copyright Copyright 2019 Thuisoft, Inc. All rights reserved.
 */
package com.thunisoft.develop.demo.service;

/**
 * ScheduledTaskActionService
 *
 * @description 定时任务接口
 * @author taogl
 * @date 2019/11/28 13:53
 * @version v1.0.0
 */
public interface ScheduledTaskActionService {

    /**
     * ScheduledTaskActionService
     *
     * @description 根据任务编号开始任务
     * @param taskId 任务编号
     * @return 是否开启成功
     * @author taogl
     * @date 2019/11/28 17:03
     * @version v1.0.0
     **/
    boolean start(String taskId);

    /**
     * ScheduledTaskActionService
     *
     * @description 根据任务编号停止任务
     * @param taskId 任务编号
     * @return 是否停止成功
     * @author taogl
     * @date 2019/11/28 17:03
     * @version v1.0.0
     **/
    void stop(String taskId);

    /**
     * ScheduledTaskActionService
     *
     * @description 根据任务编号重启任务
     * @param taskId 任务编号
     * @return 是否重启成功
     * @author taogl
     * @date 2019/11/28 17:03
     * @version v1.0.0
     **/
    boolean restart(String taskId);
}
