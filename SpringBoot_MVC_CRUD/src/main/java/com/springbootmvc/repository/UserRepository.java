package com.springbootmvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springbootmvc.entities.Users;


public interface UserRepository extends JpaRepository<Users, Integer>{

	
}
