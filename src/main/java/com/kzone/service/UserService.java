package com.kzone.service;

import java.util.List;

import com.kzone.entity.User;

public interface UserService {

	public void addUser(User user);

	public void updateUser(User user);

	public List<User> listUsers();

	public User getUserById(int id);

	public void removeUser(int id);
	
}
