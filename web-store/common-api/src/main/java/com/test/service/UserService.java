package com.test.service;

import com.test.domain.User;

public interface UserService {
    //登录
     User login(String username, String password);
     User findUserById(int uid);
}
