package com.zr.service.impl;

import com.zr.bean.User;
import com.zr.dao.UserDao;
import com.zr.service.UserService;

/**
 *
 */
public class UserServiceImpl implements UserService {
    UserDao userDao = new UserDao();

    //如果从数据库中找到了username和对应的password，说明用户可以登录，这对数据会放在user对象中，如果没有找到，user则为空，如果是空的话，函数返回false，否则说明找了，返回true。
    @Override
    public boolean login(String username, String password) {
        User user = userDao.findUserByUserNameAndPassword(username, password);
        if (user == null) {
            return false;
        } else {
            return true;
        }
    }
}