package com.home.StackOverFlowDesign;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class AnswerController {
	List<Answer> answers;

	public AnswerController() {
		this.answers = new ArrayList<>();
	}
	
	
	public void addAnswer(Answer answer) {
		this.answers.add(answer);
	}
	
	public int getTotoalVodeInAQuestion(int qId) {
		for(Answer q : answers) {
			if(q.getId() == qId) {
				return q.getVotes().size();
			}
		}
		return 0;
	}
	
	public Answer getQestionHasMaxUpVote() {
		Answer maxUpVoteAnswer = answers.stream().max(
				Comparator.comparingLong(q-> q.getVotes().stream()
				.filter(v-> v.getVoteType().equals(VoteType.UPVOTE)).count())
				).get();
		return maxUpVoteAnswer;
	}
	
	public Answer getQestionHasMaxDownVote() {
		Answer maxUpVoteAnswer = answers.stream().max(
				Comparator.comparingLong(q-> q.getVotes().stream()
				.filter(v-> v.getVoteType().equals(VoteType.DOWNVOTE)).count())
				).get();
		return maxUpVoteAnswer;
	}
}
