package de.taskmanager.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
	
	  
	//directing to index.html
	@GetMapping("/")
	public String showIndexPage() {
		
		return "index";  
	}
	
	@GetMapping("/login") 
	public String showLoginForm() {
		
		return "views/loginForm";  
	}
	
	
	  
	

}
