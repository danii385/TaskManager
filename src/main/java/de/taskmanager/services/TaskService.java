package de.taskmanager.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.taskmanager.entities.Task;
import de.taskmanager.entities.User;
import de.taskmanager.repositories.TaskRepository;

@Service
public class TaskService {
	
	@Autowired
	private TaskRepository taskRepository;
	
	public void addTask(Task task, User user) {
		task.setUser(user);
		taskRepository.save(task);
	}

	public List<Task> findUserTask(User user){	
		return taskRepository.findByUser(user);
	}
	
	public List<Task> findAll(){
		return taskRepository.findAll();	
	}
	
	public Task findOne(Long id) {
		return taskRepository.findOne(id);
	}
		
}
