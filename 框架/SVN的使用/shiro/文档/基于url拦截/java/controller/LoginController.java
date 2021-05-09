package com.sxt.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * Created by Lenovo on 2019/5/6.
 */
@Controller
public class LoginController {
    @RequestMapping("toLogin")
    public String toLongin() throws Exception{
        return "login";
    }
    @RequestMapping("/login")
    public String login(String uname, String pwd, HttpSession session) throws Exception{
        //判断用户名和密码是否匹配用户输入的用户名和密码
        if(StringUtils.isNotEmpty(uname)&&"admin".equals(uname)&&StringUtils.isNotEmpty(pwd)&&"123456".equals(pwd)){
            session.setAttribute("user",uname);
            return "main";
        }else {
            session.setAttribute("src","用户名或密码错误");
            return "login";
        }
    }
    @RequestMapping("toMain")
    public String toMain() throws Exception{
        return "main";
    }
}
