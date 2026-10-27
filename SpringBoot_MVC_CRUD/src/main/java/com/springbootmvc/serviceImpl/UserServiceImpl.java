package com.springbootmvc.serviceImpl;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.springbootmvc.dto.UserDto;
import com.springbootmvc.entities.Users;
import com.springbootmvc.helpper.UserMapper;
import com.springbootmvc.repository.UserRepository;
import com.springbootmvc.service.UserService;

@Service 
public class UserServiceImpl implements UserService {
	
	private final UserRepository userRepo;

	UserServiceImpl(UserRepository userRepo) {
		this.userRepo = userRepo;
	}

	@Override
	public UserDto saveUser(UserDto userDto) {
		
		Users user = UserMapper.dtoToEntity(userDto);
		
	Users user1 = userRepo.save(user);
		
		UserDto dtoObj = UserMapper.entityToDto(user1); 
		
		return dtoObj;
	}

	@Override
	public List<UserDto> getAllUsers() {
		
	List<Users> userlist = userRepo.findAll();
	// convert entity to dto
	List<UserDto> dtoObj = userlist.stream().map(entity-> UserMapper.entityToDto(entity)).collect(Collectors.toList()); 
	
		return dtoObj;
	}

	@Override
	public UserDto getUserById(Integer id) {
		
	Users user  = userRepo.findById(id).orElse(null);
	// convert entity to Dto
		UserDto dtoObj = UserMapper.entityToDto(user);
		return dtoObj;
	}

	@Override
	public UserDto updateUser(UserDto updateUser, Integer id) {
		
		Users user = userRepo.findById(id).orElse(null);
		if(user != null) {
			user.setName(updateUser.getName());
			user.setEmail(updateUser.getEmail());
			user.setMob(updateUser.getMob());
			user.setAddress(updateUser.getAddress());
			user.setAadhar(updateUser.getAadhar());
			user.setPan(updateUser.getPan());
			userRepo.save(user);
			
			return UserMapper.entityToDto(user);
		}
		
		return null;
	}

	@Override
	public void deleteUser(Integer id) {
		
		userRepo.deleteById(id);
		
	}

	
	

}
