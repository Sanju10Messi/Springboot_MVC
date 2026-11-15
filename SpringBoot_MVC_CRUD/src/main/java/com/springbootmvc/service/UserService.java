package com.springbootmvc.service;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.springbootmvc.dto.UserDto;


public interface UserService {

	UserDto saveUser(UserDto userDto);
	
	Page<UserDto> getAllUsers(Pageable pageable);

	UserDto getUserById(Integer id);
	
	UserDto updateUser(UserDto existingUser, Integer id);
	
	void deleteUser(Integer id);

}
