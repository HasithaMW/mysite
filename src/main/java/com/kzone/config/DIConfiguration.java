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
import com.kzone.util.encryption.AESEncryption;
import com.kzone.util.encryption.EncryptionUtil;


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
	
	@Bean(name="AESEncryption")
	public EncryptionUtil getDESEncryption() {
		return new AESEncryption();
	}
	
	@Bean
	public Interceptor getInterceptor() {
		return new HibernateInterceptor();
	}
}
