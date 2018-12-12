package com.itheima.core.service.impl;

import com.itheima.core.dao.UserDao;
import com.itheima.core.po.User;
import com.itheima.core.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Administrator on 2018/9/29.
 * 用户service接口实现类
 */
@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {
    //注入USerDao
    @Autowired
    private UserDao userDao;
    //通过账号和密码查询用户
    @Override
    public User findUser(String usercode, String password) {
        User user = this.userDao.findUser(usercode,password);
        return user;
    }
}
