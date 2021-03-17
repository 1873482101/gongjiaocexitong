package com.example.demo.dao;

import java.util.List;

import com.example.demo.pojo.User;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface Userdao {
	
	public User getUserbyId(Long id);

	public User getUserbyName(String userName);
	
	public int insertUser(User user);

	public List<User> findUsers(@Param("userName") String userName, @Param("note") String note, @Param("start") int start, @Param("limit") int limit);
	
	public int updateUser(User user);
	
	public int updateUserName(@Param("id") Long id, @Param("userName") String userName);
	
	public int deleteUser(Long id);
}
