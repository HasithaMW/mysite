package com.kzone.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kzone.dao.UserDAO;
import com.kzone.entity.User;

@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService{

	@Autowired
	@Qualifier("userDaAO")
	private UserDAO userDAO;
	
	@Override
	@Transactional(readOnly=true)
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		
		User user = userDAO.getUserByUserName(username);
		return buildUser(user);
		
	}

	private org.springframework.security.core.userdetails.User buildUser(User user){
		
		List<GrantedAuthority> result = new ArrayList<GrantedAuthority>();
		GrantedAuthority authority  = new SimpleGrantedAuthority("ROLE_ADMIN");
		result.add(authority);
		return new org.springframework.security.core.userdetails.User
				(user.getUserName(), user.getPassword(), true, true, true, true,result);
	}
	
}
