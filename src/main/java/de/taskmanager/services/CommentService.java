package de.taskmanager.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import de.taskmanager.entities.Comment;
import de.taskmanager.entities.Task;
import de.taskmanager.repositories.CommentRepository;

@Service
public class CommentService {
	
	@Autowired
	private CommentRepository commentRepository;
	
	public void addComment(Comment comment, Task task) {
		comment.setTask(task);
		commentRepository.save(comment);
	}	
	
	public List<Comment> findTaskComment(Task task){	
		return commentRepository.findByTask(task);
	}

}
