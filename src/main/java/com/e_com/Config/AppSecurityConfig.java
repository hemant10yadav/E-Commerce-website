package com.e_com.Config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

public class AppSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private DataSource securityDataSource;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().dataSource(securityDataSource);
	}
	
	@Override
	protected void configure (HttpSecurity http) throws Exception {
		http.authorizeRequests().and()
								.formLogin().loginPage("/login")
								.loginProcessingUrl("/authenticatedTheUser")
								.permitAll()
								.and()
								.logout().permitAll()
								.and()
								.exceptionHandling().accessDeniedPage("/acess-denied");
		
	}
	
}
