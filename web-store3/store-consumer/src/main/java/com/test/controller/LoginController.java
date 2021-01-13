package com.test.controller;


import com.test.result.Result;
import com.test.service.LoginService;
import io.swagger.annotations.Api;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@RestController
@Api("登录模块")
public class LoginController {
    @Autowired
    LoginService loginService;

    @Autowired
    HttpSession session;

    @ApiOperation(value = "用户登出", notes = "用户登出notes")
    @PostMapping(value = "/loginOut")
    public Result loginOUt() {
        boolean b = loginService.loginOUt(session);
        return b ? new Result<String>(400, "登出成功", null) : new Result<String>(400, "登出失败", null);
    }

    @ApiOperation(value = "用户登录", notes = "用户登录notes")
    @PostMapping(value = "/login")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", value = "用户名", defaultValue = "tong", required = true),
            @ApiImplicitParam(name = "password", value = "密码", defaultValue = "123456", required = true)
    })
    public Result<String> login(String username, String password) {
        boolean login = loginService.login(username, password);
        return login ? Result.success(null) : Result.fail500(null);
    }
}
