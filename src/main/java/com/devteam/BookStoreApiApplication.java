package com.devteam;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.devteam.entity.Role;
import com.devteam.entity.User;
import com.devteam.entity.UserRole;
import com.devteam.security.SecurityUtility;
import com.devteam.service.UserService;

@SpringBootApplication
public class BookStoreApiApplication implements CommandLineRunner {

	@Autowired
	private UserService userService;

	public static void main(String[] args) {
		SpringApplication.run(BookStoreApiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		User user1 = new User();
		user1.setFirstName("Alex");
		user1.setLastName("Sanchez");
		user1.setUsername("Asanchz93");
		user1.setPhone("0981234567");
		user1.setPassword(SecurityUtility.passwordEncoder().encode("12345678"));
		user1.setEmail("Alex_sanchez93@gmail.com");
		Set<UserRole> userRoles = new HashSet<>();
		Role role1 = new Role();
		role1.setId(1);
		role1.setName("ROLE_USER");
		userRoles.add(new UserRole(user1, role1));

		userService.createUser(user1, userRoles);

		userRoles.clear();

		User admin = new User();
		admin.setFirstName("Tri");
		admin.setLastName("Quang");
		admin.setUsername("triquang95");
		admin.setPhone("0981234567");
		admin.setPassword(SecurityUtility.passwordEncoder().encode("12345678"));
		admin.setEmail("triquang95@gmail.com");
		Role role2 = new Role();
		role2.setId(2);
		role2.setName("ROLE_ADMIN");
		userRoles.add(new UserRole(admin, role2));

		userService.createUser(admin, userRoles);
	}

}
