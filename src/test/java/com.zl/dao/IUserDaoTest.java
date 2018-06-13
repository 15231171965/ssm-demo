package com.zl.dao;

import com.zl.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 加载spring配置文件
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-mybatis.xml"})
public class IUserDaoTest {

    @Autowired
    private IUserDao userDao;

    @Test
    public void testSelectUser() throws Exception {
        User param = new User();
        param.setStatus(0);
        param.setPassword("123456");
        param.setUserName("zhangsan");

        List<User> query = userDao.query(param);
        System.err.println(query);
    }

}