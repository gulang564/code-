package com.test.controller;


import com.test.domain.User;
import com.test.service.UserService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
public class LoginController {
    @Reference(interfaceClass = UserService.class)
    UserService userService;

    @RequestMapping(value = "/LoginOutServlet")
    public String loginOUt(HttpServletRequest request, HttpServletResponse response){
        HttpSession session = request.getSession();
        session.setAttribute("currUser",null);
        return "redirect:/index.html?info=2";
    }

    @RequestMapping(value = "/mylogin")
    public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //处理用户请求
        //	1、登录请求

        HttpSession session=request.getSession();

        String username=request.getParameter("username");//与表单中的name属性值一直
        String password=request.getParameter("password");
        System.out.println(username+"=======---------========"+password);
        User user=userService.login(username, password);//调用数据访问层(com.test.dao)查询数据库
        if(user!=null) {
            //登录成功
            //session域中保存当前用户信息
            session.setAttribute("currUser", user);

            //跳转到书籍servlet
            request.setAttribute("typeid",1);

            System.out.println(request.getContextPath());

            System.out.println("=======》成功登陆");
           request.getRequestDispatcher("/showAllGoodsInfo").forward(request,response);
        }else {
            System.out.println("=======》开始转发");
            response.sendRedirect("/index.html?info=1");
        }

    }

   /* @RequestMapping(value = "/index")
    public void index(ModelAndView modelAndView){
        modelAndView.setViewName("index");
        modelAndView.addObject("info",2);
    }*/
}
