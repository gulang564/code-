package com.test.service;

import com.test.domain.User;
import org.apache.dubbo.config.annotation.Reference;
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


    public boolean loginOUt(HttpServletRequest request){
        HttpSession session = request.getSession();
        session.setAttribute("currUser",null);
        return true;
    }


    public boolean login(HttpServletRequest request,String username,String password) throws ServletException, IOException {
        //处理用户请求
        //	1、登录请求
        //调用数据访问层(com.test.dao)查询数据库
        HttpSession session = request.getSession();

        User user=userService.login(username, password);
        if(user!=null) {
            session.setAttribute("currUser",user);
            return true;
        }else {
            return false;
        }

    }
}
