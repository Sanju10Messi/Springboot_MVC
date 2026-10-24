package com.springbootmvc.serviceImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.springbootmvc.entities.Users;
import com.springbootmvc.repository.UserRepository;
import com.springbootmvc.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	private final UserRepository userRepo;

	UserServiceImpl(UserRepository userRepo) {
		this.userRepo = userRepo;
	}

	@Override
	public Users saveUser(Users user) {
		
		return userRepo.save(user);
	}

	@Override
	public List<Users> getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

}
