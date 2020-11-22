package com.adminportal.service;

import java.util.Set;

import com.adminportal.domain.User;
import com.adminportal.domain.security.PasswordResetToken;
import com.adminportal.domain.security.UserRole;

public interface UserService {
	PasswordResetToken getPasswordResetToken(final String token);
	
	void createPasswordResetToken(final User user,final String token);
	
	User findByUsername(String userName);
	
	User findByEmail(String email);
	
	User createUser(User user,Set<UserRole> userRoles) throws Exception;
	
	User save(User user) ;
}
