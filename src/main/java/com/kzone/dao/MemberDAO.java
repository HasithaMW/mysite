package com.kzone.dao;

import com.kzone.entity.Member;

public interface MemberDAO {

	Member getMemberByEmail(String email);
	
}
