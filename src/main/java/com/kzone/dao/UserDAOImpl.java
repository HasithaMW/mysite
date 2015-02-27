package com.kzone.dao;

import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.kzone.entity.User;
import com.kzone.util.encryption.HashUtil;

@Repository
// mark this as a DAO
public class UserDAOImpl implements UserDAO {

	private static final Logger logger = LoggerFactory
			.getLogger(UserDAOImpl.class);

	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	@Qualifier("spring")
	private HashUtil passHashUtil;

	public UserDAOImpl() {	
	}

	public void addUser(User user) {
		Session session = this.sessionFactory.getCurrentSession();
		session.save(user);
		logger.info("User saved successfully, User Details=" + user);

	}

	public void updateUser(User user) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(user);
		logger.info("User updated successfully, User Details=" + user);

	}

	@SuppressWarnings("unchecked")
	public List<User> listUsers() {
		Session session = this.sessionFactory.getCurrentSession();
		List<User> userList = session.createQuery(
				"select user from User as user").list();
		for (User user : userList) {
			logger.info("User List::" + user);
		}
		return userList;
	}

	public User getUserById(Long id) {
		Session session = this.sessionFactory.getCurrentSession();
		User user = (User) session.load(User.class, id);
		logger.info("User loaded successfully, User details=" + user);
		return user;
	}

	public void removeUser(Long id) {
		Session session = this.sessionFactory.getCurrentSession();
		User user = (User) session.get(User.class, id);
		if (null != user) {
			session.delete(user);
		}
		logger.info("User deleted successfully, user details=" + user);
	}

	@Override
	public void resetPassword(User user) throws GeneralSecurityException {
		Session session = this.sessionFactory.getCurrentSession();
		
		try {
			passHashUtil.createHash(user.getPassword());
		} catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
			logger.info("Failed to hash the password" + user);
			throw e;
		}
		
		String hql = "UPDATE User set password = :password WHERE id = :id";
		Query query = session.createQuery(hql);
		query.setParameter("password", user.getPassword());
		query.setParameter("id", user.getId());
		query.executeUpdate();
	}

	@Override
	public User getUserByUserName(String userName) {
		Session session = this.sessionFactory.getCurrentSession();
		List<User> userList = session.createQuery(
				"select user from User as user where user.userName =:userName")
				.setParameter("userName", userName).list();
		if(!userList.isEmpty()){
			return userList.get(0);
		}
		return null;
	}
	


}
