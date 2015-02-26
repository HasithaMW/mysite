package com.kzone.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;


@Configuration
@EnableWebMvcSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("kasun").password("123456").roles("USER");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
//		http.authorizeRequests()
//		.antMatchers("/home**").authenticated()
//		.and().formLogin().loginPage("/login.htm").permitAll();
		
		http.authorizeRequests().antMatchers("/home**").authenticated().and().formLogin()
		.loginPage("/login.htm").failureUrl("/login.htm?error")
			.usernameParameter("username")
			.passwordParameter("password")
			.and().logout().logoutSuccessUrl("/login.htm?logout")
			.and().csrf();
		
	}
}
