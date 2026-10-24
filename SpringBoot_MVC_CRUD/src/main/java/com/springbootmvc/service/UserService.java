package com.springbootmvc.service;

import java.util.List;

import com.springbootmvc.entities.Users;

public interface UserService {

	Users saveUser(Users user);
	
	List<Users> getAllUsers();
}
