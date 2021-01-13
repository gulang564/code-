package com.test.dao;

import com.test.domain.User;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends JpaRepository<User, Integer>, CrudRepository<User, Integer> {
    @Query(value = "select u from User u where u.uName=?1 and u.password=?2")
    User login(String username, String password);
}
