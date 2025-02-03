package com.home.StackOverFlowDesign;

import java.util.Date;

public class Comment {
	private final int id;
	private final String comment;
	private final User user;
	private final Date creationDate;

	public Comment(int id, String comment, User user, Date creationDate) {
		super();
		this.id = id;
		this.comment = comment;
		this.user = user;
		this.creationDate = creationDate;
	}

	public int getId() {
		return id;
	}

	public String getComment() {
		return comment;
	}

	public User getUser() {
		return user;
	}

	public Date getCreationDate() {
		return creationDate;
	}

}
