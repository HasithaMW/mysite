package com.kzone.config;

import org.hibernate.Interceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.kzone.dao.UserDAO;
import com.kzone.dao.UserDAOImpl;
import com.kzone.service.UserService;
import com.kzone.service.UserServiceImpl;
import com.kzone.util.HibernateInterceptor;
import com.kzone.util.encryption.EncryptionUtilImpl;
import com.kzone.util.encryption.EncryptionUtil;
import com.kzone.util.encryption.HashUtil;
import com.kzone.util.encryption.PasswordHash;


@Configuration
@ComponentScan("com.kzone.controller")
public class DIConfiguration {

	@Bean(name="userService")
    public UserService getUserService(){
        return new UserServiceImpl();
    }
	
	@Bean(name="userDaAO")
    public UserDAO getUserDAO(){
        return new UserDAOImpl();
    }
	
	@Bean(name="encryption")
	public EncryptionUtil getDESEncryption() {
		return new EncryptionUtilImpl();
	}
	
	@Bean
	public Interceptor getInterceptor() {
		return new HibernateInterceptor();
	}
	
	@Bean(name="passwordHash")
	public HashUtil getHashUtil() {
		return new PasswordHash();
	}
}
