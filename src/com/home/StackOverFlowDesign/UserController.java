package com.home.StackOverFlowDesign;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class UserController {

	List<User> userList;

	public UserController() {
		this.userList = new ArrayList<>();;
	}
	
	public void addUser(User user) {
		this.userList.add(user);
	}
	
	public void removeUser(int id) {
		userList.remove(id);
	}
	
	public User getUser(int id) {
		for(User user: userList) {
			if(user.getUserId() == id) return user;
		}
		return null;
	}
	
	public void addQuestion(Question question) {
		for(User u: userList) {
			if(u.getUserId() == question.getUser().getUserId()) {
				u.getQuestions().add(question);
				int existingReputationScore = u.getReupationScore() == 0 ? 5 : u.getReupationScore();
				this.updateReputatioScore(existingReputationScore, u.getUserId());
			}
		}
	}
	
	public void addAnswer(User user, Answer answer) {
		for(User u: userList) {
			if(u.getUserId() == user.getUserId()) {
				u.getAnswers().add(answer);
				int existingReputationScore = u.getReupationScore() == 0 ? 10 : u.getReupationScore();
				this.updateReputatioScore(existingReputationScore, u.getUserId());
			}
		}
	}
	
	public User userWithMaxReputationScore() {
		return this.userList.stream().max(Comparator.comparingInt(u-> u.getReupationScore())).get();
	}
	
	public synchronized void updateReputatioScore(int score, int userId) {
		for(User user: userList) {
			if(user.getUserId() == userId) {
				user.setReupationScore(user.getReupationScore()+score);
			}
		}
	}
}
