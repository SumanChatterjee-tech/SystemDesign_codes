package com.home.TaskManagementSystem;

public class Task {

	private String id;
	private String description;
	private int priority;
	private TaskStatus status;
	private User assignedUser;
	
	public Task(String id, String description, int priority, TaskStatus status, User assignedUser) {
		super();
		this.id = id;
		this.description = description;
		this.priority = priority;
		this.status = status;
		this.assignedUser = assignedUser;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public TaskStatus getStatus() {
		return status;
	}

	public void setStatus(TaskStatus status) {
		this.status = status;
	}

	public User getAssignedUser() {
		return assignedUser;
	}

	public void setAssignedUser(User assignedUser) {
		this.assignedUser = assignedUser;
	}
}
