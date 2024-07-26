package com.home.Crickbuzz;

import java.util.ArrayList;
import java.util.List;

public class OverDetails {

    int overNumber;
    List<BallDetails> balls;
    int extraBallsCount;
    PlayerDetails bowledBy;
    
	public OverDetails(int overNumber, PlayerDetails bowledBy) {
		super();
		this.overNumber = overNumber;
		this.balls = new ArrayList<>();
		this.bowledBy = bowledBy;
	}
    
    public boolean startOver(Team batting, Team bowlling, int runsToWin) {
    	int ballCount = 1;
    	while(ballCount <=6) {
    		BallDetails ball = new BallDetails(ballCount);
    		ball.startBallDelivery(batting, bowlling, this);
    		if(ball.ballType == BallType.NORMAL) {
    			this.balls.add(ball);
    			ballCount++;
//    			if(ball.wicket != null) { //will implement later
//    				batting.chooseNextBatsMan();
//    			}
    			
    			 if( runsToWin != -1 && batting.getTotalRuns() >= runsToWin){
                     batting.isWinner = true;
                     return true;
                 }
    		}else {
    			extraBallsCount++;
    		}
    	}
    	return false;
    }
}
