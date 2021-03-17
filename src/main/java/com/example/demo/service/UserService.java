package com.example.demo.service;

import java.util.List;

import com.example.demo.pojo.User;


public interface UserService {
	
	public User insertUser(User user);
	
	public User getUserbyId(Long id);

	public User getUserbyName(String userName);
	
	public List<User> findUsers(String userName, String note, int start, int limit);
	
	public int updateUser(User user);
	
	public int  updateUserName(Long id, String userName);
	
	public int deleteUser(Long id);
}
