package com.springbootmvc.service;

import java.util.List;

import com.springbootmvc.dto.UserDto;


public interface UserService {

	UserDto saveUser(UserDto userDto);
	
	List<UserDto> getAllUsers();

	UserDto getUserById(Integer id);
	
	UserDto updateUser(UserDto existingUser, Integer id);
	
	void deleteUser(Integer id);

}
