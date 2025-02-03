package com.home.StackOverFlowDesign;

public class Vote {

	User user;
	VoteType voteType;
	
    public Vote(User user, VoteType voteType) {
		super();
		this.user = user;
		this.voteType = voteType;
	}
	public User getUser() { return user; }
    public VoteType getVoteType() { return voteType; }
    
}
