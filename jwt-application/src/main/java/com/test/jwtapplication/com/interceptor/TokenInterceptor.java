package com.test.jwtapplication.com.interceptor;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;
import com.test.jwtapplication.com.service.UserService;
import com.test.jwtapplication.com.util.JwtUtil;
import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Slf4j
@Component

public class TokenInterceptor extends HandlerInterceptorAdapter {
    @Autowired
    UserService userService;

    @Autowired
    JwtUtil jwtUtil;

    @Autowired
    Gson gson;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
       log.info("拦截");
        final String authHeader = request.getHeader("Authorization");
        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            final String token = authHeader.substring(7); // The partafter "Bearer "
            Claims claims = jwtUtil.parseJWT(token);
            if (claims != null) {

                Map data = (Map) claims.get("data");

                if("admin".equals(data.get("roles"))){//如果是管理员
                    request.setAttribute("admin_claims", claims);
                }
                if("user".equals(data.get("roles"))){//如果是用户
                    request.setAttribute("user_claims", claims);
                }
                log.info("解析的用户名称为------------>"+data.get("username"));
            }

        }
        return true;

    }
}
