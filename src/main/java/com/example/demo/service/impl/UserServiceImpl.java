package com.example.demo.service.impl;

import java.util.List;

import com.example.demo.dao.Userdao;
import com.example.demo.pojo.User;
import com.example.demo.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private Userdao userDao = null;
	
	@Override
	public User getUserbyId(Long id) {
		return userDao.getUserbyId(id);
	}

	@Override
	public User getUserbyName(String userName) {
		return userDao.getUserbyName(userName);
	}

	@Override
	public List<User> findUsers(String userName, String note, int start, int limit) {
		return userDao.findUsers(userName, note, start, limit);
	}

	@Override
	public int updateUser(User user) {
		return userDao.updateUser(user);
	}

	@Override
	public int updateUserName(Long id, String userName) {
		return userDao.updateUserName(id, userName);
	}

	@Override
	public int deleteUser(Long id) {
		return userDao.deleteUser(id);
	}

	@Override
	public User insertUser(User user) {
		return userDao.insertUser(user) >0 ? user  : null;
	}
	
}
