package de.taskmanager.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import de.taskmanager.entities.Task;
import de.taskmanager.entities.User;

public interface TaskRepository  extends JpaRepository<Task, Long>{

	List<Task> findByUser(User user); 
	
	List<Task> findAll(); 
	
	Task findOne(Long id);			
}
