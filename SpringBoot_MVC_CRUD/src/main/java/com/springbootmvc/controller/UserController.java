package com.springbootmvc.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.springbootmvc.dto.UserDto;
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
		model.addAttribute("userdto", new UserDto());
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
	public String saveUser(@ModelAttribute UserDto userDto) {
	
		userService.saveUser(userDto);
		
		return "redirect:/view";
	}
	
	@GetMapping("/view")
	public String showView(Model model) {
		
	List<UserDto> userDtoList =	userService.getAllUsers();
	model.addAttribute("userDtoList", userDtoList);	
	
		return "view";
	}
	
	@GetMapping("/edit/{id}")
	public String showEdit(@PathVariable Integer id, Model model) {		

		UserDto userdto =  userService.getUserById(id);
		model.addAttribute("userdto", userdto);
		return "edit";
	}
	

	@PostMapping("/update")
	public String updateUser(@ModelAttribute UserDto userDto) {
	
	    	userService.updateUser(userDto, userDto.getId());
	
	    return "redirect:/view";
	}
    
    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable Integer id) {

    	userService.deleteUser(id);

        return "redirect:/view";
    }

	
	
	
}
