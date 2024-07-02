package com.home.LudoGameDesign;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Dice {
	int diceCount;
	
	public Dice(int diceCount) {
		super();
		this.diceCount = diceCount;
	}

	public int rollDice() {
		int total=0;
		int startdice=0;
		Random rand = new Random();
		while(startdice >= diceCount) {
			total+=rand.nextInt(5)+1;
			startdice--;
		}
		return total;
	}
}
