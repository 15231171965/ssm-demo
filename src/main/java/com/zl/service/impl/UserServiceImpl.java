package com.zl.service.impl;

import com.zl.dao.IUserDao;
import com.zl.model.User;
import com.zl.service.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("userService")
public class UserServiceImpl implements IUserService {

    @Resource
    private IUserDao userDao;


    @Override
    public User queryById(int userId) {
        return userDao.queryById(userId);
    }

    @Override
    public int delete(int userId) {
        return userDao.delete(userId);
    }

    @Override
    public int insert(User user) {
        return userDao.insert(user);
    }

    @Override
    public User login(String userName, String password) {
        return userDao.login(userName, password);
    }
}