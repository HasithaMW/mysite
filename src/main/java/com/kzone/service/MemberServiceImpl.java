package com.kzone.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kzone.dao.MemberDAO;
import com.kzone.entity.Member;

@Service("memberDetailsService")
public class MemberServiceImpl implements UserDetailsService {

	@Autowired
	@Qualifier("memberDAO")
	private MemberDAO memberDAO;
	
	
	@Transactional
	public Member getMemberByEmail(String email) {
		return memberDAO.getMemberByEmail(email);
	}

	@Transactional
	public User loadUserByUsername(String email) {
		return buildUser(memberDAO.getMemberByEmail(email));
	}
	
	private User buildUser(Member member){
		return new User(member.getEmail(), member.getPassword(), true, true, true, true,null);
	}

	
}
