package com.test.service;

import com.test.domain.User;

import java.util.Optional;

public interface UserService {
     User login(String username, String password);
     User findUserById(int uid);
}
