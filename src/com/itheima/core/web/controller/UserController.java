package com.itheima.core.web.controller;

import com.itheima.core.po.User;
import com.itheima.core.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

/**
 * Created by Administrator on 2018/9/29.
 * 用户控制器类
 */
@Controller
public class UserController {
    //注入依赖
    @Autowired
    private UserService userService;
    /***
     * 用户登录
     *
     * */
    @RequestMapping(value = "/login.action",method = RequestMethod.POST)
    public String login(String usercode, String password, Model model, HttpSession session){
        //通过账号和密码查询用户
        User user = userService.findUser(usercode,password);
        if (user != null){
            //将用户对象添加到Session
            session.setAttribute("SUER_SESSION",user);
            //跳转到主页面
            return "costomer";
        }
        model.addAttribute("mgs","账号或密码错误，请重新输入");
        //返回到登录界面
        return "login";
    }
}
