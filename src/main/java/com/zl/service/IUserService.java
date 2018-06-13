package com.zl.service;

import com.zl.model.User;

public interface IUserService {

    /**
     * 根据userId查询User表所有字段
     * @param userId
     * @return
     */
    User queryById(int userId);

    /**
     * 根据userId删除User表记录
     * @param userId
     * @return
     */
    int delete(int userId);

    /**
     * 根据一个User对象插入一条记录
     * @param user
     * @return
     */
    int insert(User user);

    /**
     * 登录
     * @param userName
     * @param password
     * @return
     */
    User login(String userName,String password);

}