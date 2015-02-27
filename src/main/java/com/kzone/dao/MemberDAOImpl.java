package com.kzone.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kzone.entity.Member;

@Repository
public class MemberDAOImpl implements MemberDAO {

	
	private static final Logger logger = LoggerFactory
			.getLogger(MemberDAOImpl.class);
	
	@Autowired
	private  SessionFactory sessionFactory;
	
	@Override
	public Member getMemberByEmail(String email) {
		
		Session  	  session = this.sessionFactory.getCurrentSession();
		Query 	 	  query   = session.getNamedQuery("Member.byEmail");
		query.setParameter("email", email);
		
		logger.info("Get Member from email " + email);
		
		List<Member>  list 	  = query.list();
		
		if(!list.isEmpty()){
			return list.get(0);
		}
		
		return null;
	}

}
