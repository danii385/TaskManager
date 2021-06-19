package de.taskmanager.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import de.taskmanager.entities.Role;

public interface RoleRepository  extends JpaRepository<Role, String>{
 
}
