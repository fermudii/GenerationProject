package com.generationc20.bookfolks.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.generationc20.bookfolks.model.User;
import com.generationc20.bookfolks.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService service;
	
	@PostMapping("/signup")
	public String signUp(@RequestParam("txtUserName") String username,
			@RequestParam("txtName") String name,
			@RequestParam("txtLastName") String lastName,
			@RequestParam("txtEmail") String email,
			@RequestParam("txtPassword") String password,
			RedirectAttributes redirectAttributes) {
		
		//Model
		User user = new User();
		user.setUsername(username);
		user.setName(name);
		user.setLastName(lastName);
		user.setEmail(email);
		user.setPassword(password);
		
		service.save(user);
		redirectAttributes.addFlashAttribute("message","Your account was created");
		return "redirect:/user/login";
	}
	
	@GetMapping("/login")
	public String login(@RequestParam("txtUsername") String username,
			@RequestParam("txtPassword") String password, RedirectAttributes redirectAttributes) {
		
		return null;
	}
	
	
	
}
