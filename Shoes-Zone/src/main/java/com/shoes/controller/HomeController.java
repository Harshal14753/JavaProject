package com.shoes.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping("/index")
	public String index() {
		return "index";
	}
	
	@GetMapping("/cart")
	public String cart() {
		return "cart";
	}
	@GetMapping("/checkout")
	public String checkout() {
		return "checkout";
	}
	@GetMapping("/contact")
	public String contact() {
		return "contact";
	}
	@GetMapping("/register")
	public String register() {
		return "register";
	}
	@GetMapping("product_details")
	public String productDetails() {
		return "product_details";
	}
}
