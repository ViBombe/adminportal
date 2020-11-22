package com.adminportal;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.adminportal.domain.User;
import com.adminportal.domain.security.Role;
import com.adminportal.domain.security.UserRole;
import com.adminportal.utility.SecurityUtility;
import com.adminportal.service.UserService;

@SpringBootApplication
public class AdminPortalApplication implements CommandLineRunner{
	
	@Autowired
	UserService userService;
	
	public static void main(String[] args) {
		SpringApplication.run(AdminPortalApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		 User user1 = new User();
		user1.setFirstName("Admin");
		user1.setLastName("Admin");
		user1.setUsername("Admin");
		user1.setPassword(SecurityUtility.passwordEncoder().encode("Admin"));
		user1.setEmail("admin24@gmail.com");
		Set<UserRole> userRole = new HashSet<>();
		Role role = new Role();
		role.setRoleId(0);
		role.setName("ROLE_ADMIN");
		userRole.add(new UserRole(user1,role));
		
		// userService.createUser(user1,userRole);
		
		if(userService.findByUsername("Admin")==null) {
			userService.createUser(user1,userRole);
		}
		
	}

}
