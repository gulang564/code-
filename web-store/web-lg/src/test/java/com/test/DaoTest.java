package com.test;

import com.test.dao.UserDAO;
import com.test.domain.User;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class DaoTest {
    @Autowired
    UserDAO userDAO;

    @Test
    public void test(){
        User userById = userDAO.findUserById(1);
        System.out.println(userById);
    }

}
