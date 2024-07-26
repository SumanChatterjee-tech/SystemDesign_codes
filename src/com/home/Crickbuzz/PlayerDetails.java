package com.home.Crickbuzz;

public class PlayerDetails {

	Person person;
	PlayerType playerType;
	BattingScoreCard battingScoreCard;
	BowlingScoreCard bowlingScoreCard;

	public PlayerDetails(Person person, PlayerType playerType) {
		super();
		this.person = person;
		this.playerType = playerType;
		this.battingScoreCard = new BattingScoreCard();
		this.bowlingScoreCard = new BowlingScoreCard();
	}

	public void printBattingScoreCard() {

		System.out.println("PlayerName: " + person.name + " -- totalRuns: " + battingScoreCard.totalRuns
				+ " -- totalBallsPlayed: " + battingScoreCard.totalBallsPlayed + " -- 4s: "
				+ battingScoreCard.totalFours + " -- 6s: " + battingScoreCard.totalSix + " -- outby: ");
	}

	public void printBowlingScoreCard() {
		System.out.println("PlayerName: " + person.name + " -- totalOversThrown: " + bowlingScoreCard.totalOversCount
				+ " -- totalRunsGiven: " + bowlingScoreCard.runsGiven + " -- WicketsTaken: "
				+ bowlingScoreCard.wicketsTaken);
	}
}
