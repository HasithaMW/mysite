package com.kzone.dao;

import java.util.List;

import com.kzone.entity.User;

public interface UserDAO {

	public void addUser(User user);
    public void updateUser(User p);
    public List<User> listUsers();
    public User getUserById(int id);
    public void removeUser(int id);
	
}
