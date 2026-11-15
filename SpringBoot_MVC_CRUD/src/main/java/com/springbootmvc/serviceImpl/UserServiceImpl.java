package com.springbootmvc.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.springbootmvc.dto.UserDto;
import com.springbootmvc.entities.Users;
import com.springbootmvc.repository.UserRepository;
import com.springbootmvc.service.UserService;

@Service 
public class UserServiceImpl implements UserService {
	
	private final UserRepository userRepo;
	
	private final ModelMapper modelMapper;
	
	UserServiceImpl(UserRepository userRepo, ModelMapper modelMapper) {
		this.userRepo = userRepo;
		this.modelMapper = modelMapper;
	}

	@Override
	public UserDto saveUser(UserDto userDto) {
		
		Users user = modelMapper.map(userDto, Users.class);
		
	Users user1 = userRepo.save(user);
		
		UserDto dtoObj = modelMapper.map(user1, UserDto.class); 
		
		return dtoObj;
	}
	

	@Override
	public Page<UserDto> getAllUsers(Pageable pageable) {
		
	Page<Users>	page = userRepo.findAll(pageable);
	// convert entity to dto
	Page<UserDto> dtoObj = page.map(u-> modelMapper.map(u, UserDto.class));
		return dtoObj;
	}

	@Override
	public UserDto getUserById(Integer id) {
		
	Users user  = userRepo.findById(id).orElse(null);
	// convert entity to Dto
		UserDto dtoObj = modelMapper.map(user, UserDto.class);
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
			
			return modelMapper.map(user, UserDto.class);
		}
		
		return null;
	}

	@Override
	public void deleteUser(Integer id) {
		
		userRepo.deleteById(id);
		
	}

	
	

}
