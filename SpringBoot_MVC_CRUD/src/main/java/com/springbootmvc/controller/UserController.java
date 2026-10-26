package com.springbootmvc.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
		
		return "redirect:/view";
	}
	
	@GetMapping("/view")
	public String showView(Model model) {
		
	List<Users> userList =	userService.getAllUsers();
	model.addAttribute("userList", userList);	
	
		return "view";
	}
	
	@GetMapping("/edit/{id}")
	public String showEdit(@PathVariable Integer id, Model model) {
		
		Users user =  userService.getUserById(id);
		model.addAttribute("userEdit", user);
		return "edit";
	}
	

@PostMapping("/update")
public String updateUser(@ModelAttribute Users user) {


    	userService.updateUser(user, user.getId());

    return "redirect:/view";
}
    
    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable Integer id) {

    	userService.deleteUser(id);

        return "redirect:/view";
    }

	
	
	
}
