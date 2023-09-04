//package com.cardManagement.cardmanagementapp.security;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//
//@Configuration
//@EnableWebSecurity
//public class ApprovalSecurityConfig extends WebSecurityConfigurerAdapter{
//	
//	public void configure(HttpSecurity http) throws Exception{
//		http.httpBasic().disable();
//		http.authorizeRequests().antMatchers(HttpMethod.POST,"/user").hasRole("ADMIN")
//		.antMatchers(HttpMethod.POST,"/login/").hasRole("ADMIN")
//		.antMatchers(HttpMethod.POST,"/login/").hasRole("USER")
//		.antMatchers(HttpMethod.PUT,"/user/update").hasRole("USER")
//		.antMatchers(HttpMethod.GET,"/users").hasRole("ADMIN")
//		.anyRequest().authenticated().and().formLogin().disable();
//		
//	}
//
//}
