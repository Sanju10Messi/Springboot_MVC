package com.springbootmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.springbootmvc.entities.Users;
import com.springbootmvc.service.UserService;

@Controller
public class UserController {
	
	private final UserService userService;

	UserController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping("/")
	public String showHome() {
		
		return "home";
	}
	
	@GetMapping("/register")
	public String showRegister(Model model) {
		model.addAttribute("user", new Users());
		return "register";
	}
	
//	@PostMapping("/save")
//	public String saveUser(@ModelAttribute Users user) {
//		
//		System.out.println(user.getEmail()+" "+user.getName()+" "+user.getAadhar()+" "+user.getPan());
//		
//		return "redirect:/";
//	}
	
	@PostMapping("/save")
	public String saveUser(@ModelAttribute Users user) {
	
		userService.saveUser(user);
		
		return "redirect:/";
	}
	
	@GetMapping("/view")
	public String showView() {
		
		return "view";
	}
	
	
	
}
