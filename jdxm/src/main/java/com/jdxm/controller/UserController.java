package com.jdxm.controller;

import com.jdxm.annotation.OperateLogs;
import com.jdxm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Created by PK on 2019/3/22.
 */
@RestController
@RequestMapping("/test")
public class UserController {

    @Autowired
    private UserService userService;

    @OperateLogs(value = "测试")
   @RequestMapping("getById/{id}")
    public Map<String,Object> getById(@PathVariable("id") int id){
       return userService.getById(id);
   }


}