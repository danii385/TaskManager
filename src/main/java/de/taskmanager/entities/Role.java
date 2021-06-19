package de.taskmanager.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity  //@Entity -> represents persistent data
public class Role {

	@Id //specifies primary key (primary key represents the entity object)
	private String name;
	
	@ManyToMany(mappedBy = "roles") //relationship between Class Role and User 
	private List<User> users;      //mappedBy -> specifies owner of relationship
	
	public Role(String name, List<User> users) {
		this.name = name;
		this.users = users;
	}

	public Role() {
	}

	public Role(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}
	
}
