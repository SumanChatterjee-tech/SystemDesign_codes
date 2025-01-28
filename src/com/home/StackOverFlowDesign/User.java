package com.home.StackOverFlowDesign;

import java.util.List;

public class User {
	int userId;
	String name;
	String email;
	List<Question> questions;
	List<Answer> answers;
	List<Comment> comments;
	int reupationScore;
	
	public User(int userId, String name, String email, List<Question> questions, List<Answer> answers,
			List<Comment> comments, int reupationScore) {
		super();
		this.userId = userId;
		this.name = name;
		this.email = email;
		this.questions = questions;
		this.answers = answers;
		this.comments = comments;
		this.reupationScore = reupationScore;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}

	public List<Answer> getAnswers() {
		return answers;
	}

	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public int getReupationScore() {
		return reupationScore;
	}

	public void setReupationScore(int reupationScore) {
		this.reupationScore = reupationScore;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", name=" + name + ", email=" + email + ", reupationScore=" + reupationScore
				+ "]";
	}
}
