package com.devteam.service;

import java.util.Set;

import com.devteam.entity.User;
import com.devteam.entity.UserRole;

public interface UserService {
	
	User createUser(User user, Set<UserRole> userRoles);
}
