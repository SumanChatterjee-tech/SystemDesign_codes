package com.home.Crickbuzz;

import java.util.ArrayList;
import java.util.List;

public class InningsDetails {

	Team batting;
	Team bowlling;
	MatchType matchType;
	List<OverDetails> overs;
	public InningsDetails(Team batting, Team bowlling, MatchType matchType) {
		super();
		this.batting = batting;
		this.bowlling = bowlling;
		this.matchType = matchType;
		this.overs = new ArrayList<>();
	}
	
	public void startInnings(int runsToWin) {
		try {
			batting.chooseNextBatsMan();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int noOfOvers = matchType.noOfOvers();
		for(int over =1 ; over<= noOfOvers ; over++) {
			
			bowlling.chooseNextBowler(matchType.maxOverCountBowlers());
			OverDetails overD = new OverDetails(over, bowlling.getCurrentBowler());
			this.overs.add(overD);
			
			boolean won = overD.startOver(batting, bowlling, runsToWin);
			if(won == true) {
                break;
            }
			
			//swap the batsman
			PlayerDetails striker = batting.getStriker();
			PlayerDetails nonStriker = batting.getNonStriker();
			batting.setNonStriker(striker);
			batting.setStriker(nonStriker);
		}
	}
	 public int getTotalRuns(){
	       return batting.getTotalRuns();
	 }
}
