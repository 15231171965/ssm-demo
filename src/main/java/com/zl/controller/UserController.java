package com.zl.controller;

import javax.servlet.http.HttpServletRequest;

import com.zl.model.User;
import com.zl.service.IUserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Resource
    private IUserService userService;

    /**
     * 不跳转页面的方法加ResponseBody
     * @param request
     * @param response
     * @param id
     * @throws IOException
     */
    @RequestMapping(value = "/showUser.do",produces="text/html;charset=UTF-8;")
    @ResponseBody
    public String selectUser(HttpServletRequest request, HttpServletResponse response,
                           @RequestParam(value = "id",required = false) String id) throws IOException {
        if (id == null)
            return "非法请求";
        int userId = Integer.parseInt(id);
        User user = this.userService.queryById(userId);
        return user.toString();
    }

    @RequestMapping(value = "/login.html",produces="text/html;charset=UTF-8;")
    public String login(){
        return "login";
    }

    @RequestMapping(value = "/doLogin",produces="text/html;charset=UTF-8;")
    public String doLogin(@RequestParam(value = "username",required = false) String userName,
                          @RequestParam(value = "password",required = false) String passWord){
        if (userName == null || passWord == null){
            return "error";
        }
         else//写业务
        if(userService.login(userName,passWord)!=null) {
            return "success";
        }
        return "loginError";
    }

    @RequestMapping("/params")
    public String doLogin(HttpServletRequest request,HttpServletResponse response){
        Enumeration<String> parameterNames = request.getParameterNames();
        while (parameterNames.hasMoreElements()){
            String name = parameterNames.nextElement();
            System.out.println(name + "-------->" + request.getParameter(name));
        }
        return "ueditorSuccess";
    }
}