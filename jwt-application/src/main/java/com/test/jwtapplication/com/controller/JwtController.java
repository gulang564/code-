package com.test.jwtapplication.com.controller;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.test.jwtapplication.com.bean.Admin;
import com.test.jwtapplication.com.service.UserService;
import com.test.jwtapplication.com.util.JwtUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@Slf4j
public class JwtController {

    @Autowired
    JwtUtil jwtUtil;

    @Autowired
    UserService userService;

    @RequestMapping(value="login")
    public Map login( Admin admin){
        Admin user = userService.findByLoginnameAndPassword(admin.getUserName(),admin.getPassWord());
        if(user!=null){
            //生成token
            log.info("用户名：{},密码：{}",admin.getUserName(),admin.getPassWord());

            Map hashMap = new HashMap();
            hashMap.put("username",user.getUserName());
            hashMap.put("roles","admin");

            String token = jwtUtil.createJWT(user.getId().toString(),user.getUserName(), hashMap);
            Map map=new HashMap();
            map.put("token",token);
            map.put("username",user.getUserName());//登陆名
            return map;
        }else{
            return null;
        }
    }


    @GetMapping(value = "test")
    public String test(){
        return "test";
    }
}
