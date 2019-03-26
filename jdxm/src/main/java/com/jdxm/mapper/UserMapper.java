package com.jdxm.mapper;

import com.jdxm.entity.basic.User;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public interface UserMapper {
    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer uid);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    User queryUserName(String username);

    Map<String,Object> getById(int id);
}