package com.kzone.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kzone.dao.UserDAO;
import com.kzone.entity.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	@Qualifier("userDaAO")
	private UserDAO userDAO;
	
	
	public UserServiceImpl() {
	}
	
	@Transactional
	public void addUser(User user) {
		this.userDAO.addUser(user);

	}

	@Transactional
	public void updateUser(User user) {
		this.userDAO.updateUser(user);

	}

	@Transactional
	public List<User> listUsers() {
		return this.userDAO.listUsers();
	}

	@Transactional
	public User getUserById(Long id) {
		return this.userDAO.getUserById(id);
	}

	@Transactional
	public void removeUser(Long id) {
		this.userDAO.removeUser(id);

	}

}
