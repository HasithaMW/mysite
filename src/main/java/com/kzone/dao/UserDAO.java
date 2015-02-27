package com.kzone.dao;

import java.security.GeneralSecurityException;
import java.util.List;

import com.kzone.entity.User;

public interface UserDAO {

	public void addUser(User user);
    public void updateUser(User p);
    public List<User> listUsers();
    public User getUserById(Long id);
    public void removeUser(Long id);
    public User getUserByUserName(String email);
    
    public void resetPassword(User user)throws GeneralSecurityException;
	
}
