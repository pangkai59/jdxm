package com.jdxm.mapper;


import com.jdxm.entity.basic.Module;

public interface ModuleMapper {
    int deleteByPrimaryKey(Integer mid);

    int insert(Module record);

    int insertSelective(Module record);

    Module selectByPrimaryKey(Integer mid);

    int updateByPrimaryKeySelective(Module record);

    int updateByPrimaryKey(Module record);
}