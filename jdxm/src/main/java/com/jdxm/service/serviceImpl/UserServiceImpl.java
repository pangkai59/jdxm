package com.jdxm.service.serviceImpl;

import com.jdxm.mapper.UserMapper;
import com.jdxm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Created by PK on 2019/3/22.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
     UserMapper userMapper;

    @Override
    public Map<String, Object> getById(int id) {
      return   userMapper.getById(id);
    }
}