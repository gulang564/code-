package com.test.jwtapplication.com.repository;

import com.test.jwtapplication.com.bean.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Admin,Long> {
}
