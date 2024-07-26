package com.home.Crickbuzz;

import java.util.ArrayList;
import java.util.List;


public class BallDetails {

	public int ballNumber;
	public BallType ballType;
	public RunType runType;
	public PlayerDetails playedBy;
	public PlayerDetails bowledBy;
	List<ScoreUpdaterObserver> scoreUpdaterObserverList = new ArrayList<>();

	public BallDetails(int ballNumber) {
		this.ballNumber = ballNumber;
		scoreUpdaterObserverList.add(new BowlingScoreUpdater());
		scoreUpdaterObserverList.add(new BattingScoreUpdater());
	}

	public void startBallDelivery(Team battingTeam, Team bowlingTeam, OverDetails over) {
		// implement later
		this.playedBy = battingTeam.getStriker();
		this.bowledBy = over.bowledBy;
		this.ballType = BallType.NORMAL;

		this.runType = getRunType();
		
		//swap the palyers if run is one or two
		if(runType == RunType.ONE || runType == RunType.THREE) {
            //swap striket and non striker
            PlayerDetails temp = battingTeam.getStriker();
            battingTeam.setStriker(battingTeam.getNonStriker());
            battingTeam.setNonStriker(temp);
        }
		//notify update
		notifyUpdaters(this);
	}
	
	public void notifyUpdaters(BallDetails ballDetails) {
		for(ScoreUpdaterObserver scoreUpdaterObserver : this.scoreUpdaterObserverList) {
			scoreUpdaterObserver.update(ballDetails);
		}
	}

	public RunType getRunType() {
		double val = Math.random();
		if (val <= 0.2) {
			return RunType.ONE;
		} else if (val >= 0.3 && val <= 0.5) {
			return RunType.TWO;
		} else if (val >= 0.6 && val <= 0.8) {
			return RunType.FOUR;
		} else {
			return RunType.SIX;
		}
	}
}
