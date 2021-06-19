package de.taskmanager.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import de.taskmanager.entities.Comment;
import de.taskmanager.entities.Task;

public interface CommentRepository extends JpaRepository<Comment, Long>{
	
	List<Comment> findByTask(Task task);
	
}
