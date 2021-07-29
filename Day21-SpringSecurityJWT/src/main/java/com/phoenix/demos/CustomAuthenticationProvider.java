package com.phoenix.demos;

import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		
		String userName=authentication.getName();
		String password=String.valueOf(authentication.getCredentials());
		
		if("Phoenix".equals(userName) && "root".equals(password))
		{
			return new UsernamePasswordAuthenticationToken(userName, password);
		}
		else
		{
			throw new AuthenticationCredentialsNotFoundException("You are not allowed here");
		}
	}

	@Override
	public boolean supports(Class<?> authentication) {
		
		return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication); 

	}

}
