package com.jdxm.mapper;


import com.jdxm.entity.basic.UserRole;

public interface UserRoleMapper {
    int insert(UserRole record);

    int insertSelective(UserRole record);
}