package de.taskmanager.controllers;

import java.security.Principal;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import de.taskmanager.entities.Comment;
import de.taskmanager.entities.Task;
import de.taskmanager.entities.User;
import de.taskmanager.services.CommentService;
import de.taskmanager.services.TaskService;
import de.taskmanager.services.UserService;

@Controller
public class TaskController {

	 @Autowired
	 private TaskService taskService;
	 @Autowired
	 private UserService  userService;
	 @Autowired
	 private CommentService commentService;
	 
	 
	 //--------------------------------Admin Add Task------------------------------------
	 @GetMapping("/addTask")
	 public String taskForm(String email, Model model, HttpSession session) {	 
		 session.setAttribute("email", email); 
		 model.addAttribute("task", new Task());
		 return "views/taskForm"; 
	 }
	 
	 @PostMapping("/addTask")
	 public String addTask(@Valid Task task,BindingResult bindingResult, HttpSession session) {
		 if(bindingResult.hasErrors()) {
			 return "views/taskForm";
		 }
		 String email = (String) session.getAttribute("email");
		 taskService.addTask(task, userService.findOne(email));
		 
		return "redirect:/users";
	 }	
	 
	  
	 
	 //------------------------------Admin Task Overview---------------------------------
	 @GetMapping("/taskList")
	 public String listTasks(Model model, @RequestParam(defaultValue="")  String name) {
			model.addAttribute("tasks", taskService.findAll());
			return "views/taskList";
	 }
	 
	//--------------------------------Add Comment to Task------------------------------
	 
		@GetMapping("/addComment")
		public String commentForm(Long id, Model model, HttpSession session) {
			session.setAttribute("id", id);
			model.addAttribute("comment", new Comment());
			return "views/commentForm";
		}

		@PostMapping("/addComment")
		public String addComment(@Valid Comment comment, BindingResult bindingResult, HttpSession session, Principal principal) {
			if (bindingResult.hasErrors()) {
				return "views/commentForm";
			}
			Long id = (Long) session.getAttribute("id");
			commentService.addComment(comment, taskService.findOne(id));
			if(principal.getName().equals("admin@mail.com")) {
				return "redirect:/taskList";
			}
			else {
				return "redirect:/profile";
			}
			
		}
		
		//---------------------------Show Comments of a Task---------------------------
		
		@GetMapping("/comments")
		public String showComments(Model model, Long id) {
			
			Task task = taskService.findOne(id);
			model.addAttribute("comments", commentService.findTaskComment(task));
				
			return "views/comments";
		}
	 	 
	
}
