package com.springbootmvc.helpper;

import com.springbootmvc.dto.UserDto;
import com.springbootmvc.entities.Users;

public class UserMapper {

	public static Users dtoToEntity(UserDto userDto) {
		
		// convert Dto to entity
		Users user = new Users();
		user.setName(userDto.getName());
		user.setEmail(userDto.getEmail());
		user.setPassword(userDto.getPassword());
		user.setMob(userDto.getMob());
		user.setAddress(userDto.getAddress());
		user.setAadhar(userDto.getAadhar());
		user.setPan(userDto.getPan());
		
		return user;
	}
	
	public static UserDto entityToDto(Users user) {
		
		//convert entity to Dto
		UserDto userDto = new UserDto();
		userDto.setId(user.getId());
		userDto.setName(user.getName());
		userDto.setEmail(user.getEmail());
		
		userDto.setMob(user.getMob());
		userDto.setAddress(user.getAddress());
		userDto.setAadhar(user.getAadhar());
		userDto.setPan(user.getPan());
		
		return userDto;
		
	}
	
}
