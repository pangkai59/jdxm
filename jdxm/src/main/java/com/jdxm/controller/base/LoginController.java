package com.jdxm.controller.base;

import com.jdxm.annotation.OperateLogs;
import com.jdxm.entity.basic.User;
import com.jdxm.utils.RedisCacheUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("login")
public class LoginController {

    @RequestMapping("/logininfo")
    public String login() {
        System.out.println("login");
        return "login";
    }

    @OperateLogs(value="测试")
    @RequestMapping("/a")
    public String a() {
        System.out.println("a");
        return "a";
    }

    @OperateLogs(value="测试")
    @RequestMapping("/loginUser")
    public String loginUser(String username,String password,HttpSession session) {
        //授权认证
        UsernamePasswordToken usernamePasswordToken=new UsernamePasswordToken(username,password);
        Subject subject = SecurityUtils.getSubject();
        try {
            //完成登录
            subject.login(usernamePasswordToken);
            //获得用户对象
            User user=(User) subject.getPrincipal();
            //存入session
            session.setAttribute("user", user);
            return "success";
        } catch(Exception e) {
            return "login.html";//返回登录页面
        }

    }
    @RequestMapping("/logOut")
    public String logOut(HttpSession session) {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        session.removeAttribute("user");
        return "login";
    }
}
