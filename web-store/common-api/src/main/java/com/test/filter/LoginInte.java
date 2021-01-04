package com.test.filter;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Component
public class LoginInte implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session=request.getSession();
        Object user=session.getAttribute("currUser");

        if(user!=null) {
            // 已登录  放行
           return true;
        }else {
            //未登录  跳转到登录页
            response.sendRedirect("index.html?info=2");
        }
        return false;
    }
}
