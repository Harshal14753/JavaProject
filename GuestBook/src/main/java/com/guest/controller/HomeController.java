package com.guest.controller;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.guest.entity.FeedbackData;
import com.guest.service.HomeServiceImpl;

@Controller
public class HomeController {
	
	@Autowired
	private HomeServiceImpl homeService;
	
	@ModelAttribute
	public void getAll(Model m) {
		List<FeedbackData> data = homeService.getData();
		Collections.reverse(data);
		m.addAttribute("data",data);
	}

	@GetMapping("/")
	public String home() {
		return "home";
	}
	
	@PostMapping("/saveData")
	public String saveData(@ModelAttribute FeedbackData data) {
		homeService.saveData(data);
		return "redirect:/";
	}
}
