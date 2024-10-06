package com.notes.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.notes.entity.User;
import com.notes.repository.UserRepo;
import com.notes.service.UserServiceImpl;

import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController {

	@Autowired
	private UserServiceImpl userService;

	@Autowired
	private UserRepo userRepo;

	@ModelAttribute
	public void commanUser(Principal p, Model model) {
		
		if (p != null) {
			String email = p.getName();
			User user = userRepo.findByEmail(email);
			model.addAttribute("user", user);
		}
	}

	@GetMapping("/index")
	public String index() {
		return "index";
	}

	@GetMapping("/register")
	public String register() {
		return "register";
	}

	@PostMapping("/saveUser")
	public String saveUser(@ModelAttribute User user, @RequestParam String password_confirmation, HttpSession session) {

		User newUser = null;

		if (password_confirmation.equals(user.getPassword())) {
			newUser = userService.saveUser(user);
		}

		if (newUser != null) {
			session.setAttribute("msg1", "Success! ");
			session.setAttribute("msg2", "User register successfully");
		} else {
			session.setAttribute("msg1", "Error");
			session.setAttribute("msg2", "User not register");
		}

		return "redirect:/register";
	}

	@GetMapping("/login")
	public String login() {
		return "login";
	}

//	@GetMapping("/user/profile")
//	public String profile(Principal p, Model model) {
//		String email = p.getName();
//		User user = userRepo.findByEmail(email);
//		model.addAttribute("user", user);
//		return "profile";
//	}

	

}
