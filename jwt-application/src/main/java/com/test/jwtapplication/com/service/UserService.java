package com.test.jwtapplication.com.service;

import com.test.jwtapplication.com.bean.Admin;
import com.test.jwtapplication.com.repository.UserRepository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public Admin findByLoginnameAndPassword(String username, String password) {
        Admin user = new Admin();
        user.setUserName(username);
        user.setPassWord(password);
//        Example example = Example.create(user);
        Example<Admin> example=Example.of(user);
        Optional<Admin> one = userRepository.findOne(example);
        Admin user1 = one.get();
        if (user1!= null){
            return user1;
        }
        return null;
    }
}
