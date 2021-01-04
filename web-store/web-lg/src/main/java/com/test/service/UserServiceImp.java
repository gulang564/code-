package com.test.service;


import com.test.dao.UserDAO;
import com.test.domain.User;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class UserServiceImp implements UserService {
    @Autowired
    public UserDAO userDAO;
    //登录
    public User login(String username, String password){
      return userDAO.login(username,password);
    }
    public  User findUserById(int uid){
       return userDAO.findUserById(uid);
    }
}
