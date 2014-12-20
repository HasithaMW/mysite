package com.kzone.config;

import org.hibernate.Interceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.kzone.dao.UserDAO;
import com.kzone.dao.UserDAOImpl;
import com.kzone.service.UserService;
import com.kzone.service.UserServiceImpl;
import com.kzone.util.DESEncryption;
import com.kzone.util.EncryptionUtil;
import com.kzone.util.HibernateInterceptor;


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
	
	@Bean(name="DESEncryption")
	public EncryptionUtil getDESEncryption() {
		return new DESEncryption();
	}
	
	@Bean
	public Interceptor getInterceptor() {
		return new HibernateInterceptor();
	}
}
