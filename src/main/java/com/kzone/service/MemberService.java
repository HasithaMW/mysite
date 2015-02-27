package com.kzone.service;

import org.springframework.security.core.userdetails.User;

import com.kzone.entity.Member;

public interface MemberService {

	Member getMemberByEmail(String email);
	User   getUserByEmail(String email);
}
