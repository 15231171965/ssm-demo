package com.zl.dao;

import com.zl.model.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IUserDao {

    User queryById(@Param("id") int id);

    List<User> query(User user);

    int delete(@Param("id") int userId);

    int insert(User user);

    User login(@Param("userName") String userName,
               @Param("password") String password);

}