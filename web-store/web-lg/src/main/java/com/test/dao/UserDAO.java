package com.test.dao;


import com.test.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;


@Mapper
public interface UserDAO {
	//登录
	@Select("select * from \"user\" where u_name=#{username} and password=#{password}")
	User login(@Param("username") String username, @Param("password") String password);

	@Select("select * from \"user\" where u_id=#{uid}")
	User findUserById(int uid);
}
