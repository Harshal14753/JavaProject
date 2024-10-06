package com.todo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.todo.entity.Task;
import com.todo.service.HomeServiceImpl;


@Controller
public class HomeController {
	
	@Autowired
	private HomeServiceImpl homeService;
	
	@ModelAttribute
	public void runAll(Model m) {
		List<Task> task = homeService.getAllTask();
		m.addAttribute("task", task);
	}
	
	@GetMapping("/home")
	public String home() {
		return "home";
	}
	
	@PostMapping("/addTask")
	public String addTask(@RequestParam String description){
		homeService.addTask(description);
		return "redirect:/home";
	}
	
	@GetMapping("/deleteTask/{id}")
	public String deleteTask(@PathVariable int id) {
		homeService.deleteTask(id);
		return "redirect:/home";
	}
	
}
