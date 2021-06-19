package de.taskmanager.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Comment {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@NotEmpty 
	private String time;
	
	@NotEmpty 
	private String date;
	
	@NotEmpty
	@Column(length = 1000)
	private String commentText;
	
	@ManyToOne
	@JoinColumn(name = "TASK_ID")
	public Task task;

	public Comment(String time, String date, String commentText, Task task) {
		this.time = time;
		this.date = date;
		this.commentText = commentText;
		this.task = task;
	}
	
	public Comment(String time, String date, String commentText) {
		this.time = time;
		this.date = date;
		this.commentText = commentText;
	}

	public Comment() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getCommentText() {
		return commentText;
	}

	public void setCommentText(String comment) {
		this.commentText = comment;
	}

	public Task getTask() {
		return task;
	}

	public void setTask(Task task) {
		this.task = task;
	}

}
