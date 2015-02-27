package com.kzone.service;

import java.security.GeneralSecurityException;
import java.util.List;

import com.kzone.entity.User;

public interface UserService {

	public void addUser(User user);

	public void updateUser(User user);

	public List<User> listUsers();

	public User getUserById(Long id);

	public void removeUser(Long id);
	
	public void resetPassword(User user)throws GeneralSecurityException;
	
	public User getUserByUserName(String userName);
}
