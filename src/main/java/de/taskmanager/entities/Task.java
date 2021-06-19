package de.taskmanager.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Task {
	@Id
	@GeneratedValue // value is generated automatically
	private Long id;

	@NotEmpty // must not be null
	private String date;

	@NotEmpty
	private String startTime;

	@NotEmpty
	private String stopTime;

	@NotEmpty
	@Column(length = 1000) // specifie mapped column as VARCHAR(1000), else error
	private String description;

	@ManyToOne
	@JoinColumn(name = "USER_EMAIL")
	public User user;
	
	//OneToMany -> ein user kann mehrere Tasks haben
	@OneToMany(mappedBy = "task", cascade = CascadeType.ALL)
	private List<Comment> comments;

	public Task(String date, String startTime, String stopTime, String description, User user) {
		this.date = date;
		this.startTime = startTime;
		this.stopTime = stopTime;
		this.description = description;
		this.user = user;
	}

	public Task(String date, String startTime, String stopTime, String description) {
		this.date = date;
		this.startTime = startTime;
		this.stopTime = stopTime;
		this.description = description;
	}

	public Task() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getStopTime() {
		return stopTime;
	}

	public void setStopTime(String stopTime) {
		this.stopTime = stopTime;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
