package com.test.service;


import com.test.dao.UserRepository;
import com.test.domain.User;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    public UserRepository userRepository;

    @Override
    public User login(String username, String password){
       return userRepository.login(username,password);
    }
    @Override
    public User findUserById(int uid){
       return userRepository.findById(uid).get();
    }
}
