package com.phoenix.demos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class CustomWebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	CustomAuthenticationProvider authenticationProvider;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.authenticationProvider(authenticationProvider);
		
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.httpBasic();
	//	http.authorizeRequests().anyRequest().authenticated();

	}

	
}


/*
 * Class AuthenticationManagerBuilder {
 * 
 * AuthenticationProvider ref;
 * 
 * public authenticationProvider(AuthenticationProvider objRef) {
 * this.ref=objRef; }
 * 
 * public AuthenticationManager build() { return new AuthenticationManager(ref);
 * } }
 */
