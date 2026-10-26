package com.springbootmvc.service;

import java.util.List;

import com.springbootmvc.entities.Users;

public interface UserService {

	Users saveUser(Users user);
	
	List<Users> getAllUsers();

	Users getUserById(Integer id);
	
	Users updateUser(Users existingUser, Integer id);
	
	void deleteUser(Integer id);

}
