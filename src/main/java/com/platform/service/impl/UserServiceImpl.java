package com.platform.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.platform.dao.UserDao;
import com.platform.model.Count;
import com.platform.model.PageBean;
import com.platform.model.User;
import com.platform.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserDao userDao;
	@Override
	public int insertUser(User user) {
		return userDao.insertUser(user);
	}
	
	@Override
	public User findUserById(int id) {
		return userDao.findUsersById(id);
	}

	@Override
	public int updateUser(User user) {
		return userDao.updateUser(user);
	}

	@Override
	public int deleteUser(int id) {
		return userDao.deleteUser(id);
	}

	@Override
	public Count countUser() {
		return userDao.countUser();
	}

	@Override
	public List<User> findUsersByPage(PageBean page) {
		return userDao.findUsersByPage(page);
	}

	@Override
	public List<User> findUserByNameAndPwd(User user) {
		
		return userDao.findUserByNameAndPwd(user);
	}

	@Override
	public void dataDump() {
		userDao.dataDump();
		
	}

	@Override
	public int findMaxId() {
		return userDao.findMaxId();
	}
	
	
}
