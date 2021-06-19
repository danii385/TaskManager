package de.taskmanager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import de.taskmanager.entities.User;
import de.taskmanager.services.UserService;

@SpringBootApplication
public class TaskManagerApplication implements CommandLineRunner {
	@Autowired
	private UserService userService;

	public static void main(String[] args) {
		SpringApplication.run(TaskManagerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		{
			User newAdmin = new User("admin@mail.com", "Admin", "123456");
			userService.createAdmin(newAdmin);
		}
	}
}
