package com.home.Crickbuzz;

import java.util.Date;

public class Match {

	Team temaA;
	Team teamB;
	Date date;
	String venue;
	InningsDetails[] innings;
    MatchType matchType;
	public Match(Team temaA, Team teamB, Date date, String venue, InningsDetails[] innings, MatchType matchType) {
		super();
		this.temaA = temaA;
		this.teamB = teamB;
		this.date = date;
		this.venue = venue;
		this.innings = new InningsDetails[2];
		this.matchType = matchType;
	}
    
    public void startMatch() {
    	//implement later
    }
}
