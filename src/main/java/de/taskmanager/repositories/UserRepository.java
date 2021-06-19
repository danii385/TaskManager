package de.taskmanager.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import de.taskmanager.entities.User;
// JpaRepository(entity type, primary key)
public interface UserRepository  extends JpaRepository<User, String> {

	List<User> findByNameLike(String name); 
	

}
