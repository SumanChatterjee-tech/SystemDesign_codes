package com.home.StackOverFlowDesign;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Question {
	int id;
	String question;
	User user;
	List<Vote> votes;
	List<Answer> answers;
	List<Comment> comments;
	Date date;
	boolean isAccepted;
	public Question(int id, String question, User user) {
		super();
		this.id = id;
		this.question = question;
		this.user = user;
		this.votes = new ArrayList<>();
		this.answers = new ArrayList<>();
		this.comments = new ArrayList<>();
		this.date = new Date();
		this.isAccepted = false;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public List<Vote> getVotes() {
		return votes;
	}
	public void setVotes(List<Vote> votes) {
		this.votes = votes;
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
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public boolean isAccepted() {
		return isAccepted;
	}
	public void setAccepted(boolean isAccepted) {
		this.isAccepted = isAccepted;
	}
	
	public void addAnswer(Answer answer) {
		this.answers.add(answer);
	}
	
	public void removeAnswer(Answer answer) {
		this.answers.remove(answer);
	}
	
	public void addComment(Comment comment) {
		this.comments.add(comment);
	}
	
	public void removeComment(Comment comment) {
		this.comments.remove(comment);
	}
	
	public void addVoteToQuestion(Vote vote) {
		this.votes.add(vote);
	}
}
