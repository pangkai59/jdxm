package com.jdxm.service.serviceImpl.base;

import com.jdxm.entity.basic.SysLog;
import com.jdxm.mapper.base.SysLogMapper;
import com.jdxm.service.base.SysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * User: PK
 * Date: 2019/3/26
 * Time: 11:20
 */
@Service
public class SysLogServiceImpl implements SysLogService {


    @Autowired
    private SysLogMapper sysLogMapper;

    @Override
    public int insert(SysLog sysLog) {
        return sysLogMapper.insert(sysLog);
    }
}