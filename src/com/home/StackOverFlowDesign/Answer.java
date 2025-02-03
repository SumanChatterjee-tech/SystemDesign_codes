package com.home.StackOverFlowDesign;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Answer {
	int id;
	String answer;
	User user;
	List<Comment> comments;
	List<Vote> votes;
	Date date;
	boolean isAccepted;
	public Answer(int id, String answer, User user) {
		super();
		this.id = id;
		this.answer = answer;
		this.user = user;
		this.comments = new ArrayList<>();
		this.votes = new ArrayList<>();
		this.date = new Date();
		this.isAccepted = false;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public List<Comment> getComments() {
		return comments;
	}
	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
	public List<Vote> getVotes() {
		return votes;
	}
	public void setVotes(List<Vote> votes) {
		this.votes = votes;
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
	
	public void addVoteToQuestion(Vote vote) {
		this.votes.add(vote);
	}
	@Override
	public String toString() {
		return "Answer [id=" + id + ", answer=" + answer + ", user=" + user + ", comments=" + comments + ", votes="
				+ votes + ", date=" + date + ", isAccepted=" + isAccepted + "]";
	}
}
