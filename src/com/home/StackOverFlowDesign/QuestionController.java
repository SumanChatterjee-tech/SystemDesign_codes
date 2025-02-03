package com.home.StackOverFlowDesign;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class QuestionController {

	List<Question> questions;

	public QuestionController() {
		this.questions = new ArrayList<>();
	}
	
	public void addQuestion(Question question) {
		this.questions.add(question);
	}
	
	public void addAnswer(Question question, User user, Answer answer) {
		for(Question q: questions) {
			if(q.id == question.id) {
				
			}
		}
	}
	
	public int getTotoalVodeInAQuestion(int qId) {
		for(Question q : questions) {
			if(q.getId() == qId) {
				return q.getVotes().size();
			}
		}
		return 0;
	}
	
	public Question getQestionHasMaxUpVote() {
		Question maxUpVoteQuestion = questions.stream().max(
				Comparator.comparingLong(q-> q.getVotes().stream()
				.filter(v-> v.getVoteType().equals(VoteType.UPVOTE)).count())
				).get();
		return maxUpVoteQuestion;
	}
	
	public Question getQestionHasMaxDownVote() {
		Question maxUpVoteQuestion = questions.stream().max(
				Comparator.comparingLong(q-> q.getVotes().stream()
				.filter(v-> v.getVoteType().equals(VoteType.DOWNVOTE)).count())
				).get();
		return maxUpVoteQuestion;
	}
}
