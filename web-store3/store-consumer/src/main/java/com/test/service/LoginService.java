package com.test.service;

import com.test.domain.User;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author tong
 */
@Service
public class LoginService {
    @Reference(interfaceClass = UserService.class)
    UserService userService;

    @Autowired
    HttpSession session;

    public boolean loginOUt(HttpSession session) {
        session.removeAttribute("currUser");
        return true;
    }


    public boolean login(String username, String password) {
        //处理用户请求
        //	1、登录请求
        //调用数据访问层(com.test.dao)查询数据库
        User currUser = (User) session.getAttribute("currUser");
        if (currUser != null) {
            System.out.println(currUser);
            return true;
        } else {
            User user = userService.login(username, password);
            if (user != null) {
                session.setAttribute("currUser", user);
                return true;
            } else {
                return false;
            }
        }
    }
}
