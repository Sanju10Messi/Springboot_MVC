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
	List<Users> userlist = userRepo.findAll();
		return userlist;
	}

	@Override
	public Users getUserById(Integer id) {
		
	Users user  = userRepo.findById(id).orElse(null);
		
		return user;
	}

	@Override
	public Users updateUser(Users updateUser, Integer id) {
		
		Users user = getUserById(id);
		if(user != null) {
			user.setName(updateUser.getName());
			user.setEmail(updateUser.getEmail());
			user.setMob(updateUser.getMob());
			user.setAddress(updateUser.getAddress());
			user.setAadhar(updateUser.getAadhar());
			user.setPan(updateUser.getPan());
			
			userRepo.save(user);
		}
		
		return user;
	}

	@Override
	public void deleteUser(Integer id) {
		
		userRepo.deleteById(id);
		
	}

	
	

}
