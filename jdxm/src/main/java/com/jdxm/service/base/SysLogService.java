package com.jdxm.service.base;

import com.jdxm.entity.basic.SysLog;

/**
 * Created by admin on 2019/3/26.
 */
public interface SysLogService {

    /**
    *@Description:   添加操作日志
    *@Param:
    *@Author: PK
    *@date: 2019/3/26
    */
    int insert(SysLog sysLog);


}
