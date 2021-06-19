package de.taskmanager.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import de.taskmanager.entities.Role;
import de.taskmanager.entities.User;
import de.taskmanager.repositories.UserRepository;

@Service
public class UserService {

	@Autowired // get a instance of UserRepository and inject it in UserService
	private UserRepository userRepository;

	public void createUser(User user) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		user.setPassword(encoder.encode(user.getPassword()));
		Role userRole = new Role("USER");
		List<Role> roles = new ArrayList<>();
		roles.add(userRole);
		user.setRoles(roles);
		userRepository.save(user);
	}

	public void createAdmin(User user) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		user.setPassword(encoder.encode(user.getPassword()));
		Role userRole = new Role("ADMIN");
		List<Role> roles = new ArrayList<>();
		roles.add(userRole);
		user.setRoles(roles);
		userRepository.save(user);
	}

	public User findOne(String email) {
		return userRepository.findOne(email);
	}

	public boolean isUserPresent(String email) {
		User u = userRepository.findOne(email);
		if (u != null) {
			return true;
		} else {
			return false;
		}
	}

	public List<User> findByName(String name) {
		return userRepository.findByNameLike(name + "%");
	}
	
}
