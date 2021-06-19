package de.taskmanager.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import de.taskmanager.entities.User;
import de.taskmanager.services.UserService;

@Controller
public class RegisterController {
	@Autowired
	private UserService userService;

	//return form when a register request is submitted to server
	@GetMapping("/register")
	public String registerForm(Model model) {

		model.addAttribute("user", new User());
		return "views/registerForm";
	}
	
	
	@PostMapping("/register")
    public String registerUser(@Valid User user, BindingResult bindingResult, Model model) {
		if(bindingResult.hasErrors()) {
			return "views/registerForm";
		}
		//check if the User already exists
		if(userService.isUserPresent(user.getEmail())) {
			model.addAttribute("exist",true);

			//returns error massage
			return "views/registerForm";

		}
		userService.createUser(user);
		
		return "views/success";

	}

}
