package com.itheima.core.service;

import com.itheima.core.po.User;

/**
 * Created by Administrator on 2018/9/29.
 * 用户service层接口
 */
public interface UserService {
    //通过账号和密码查询用户
    public User findUser(String usercode,String password);

}
