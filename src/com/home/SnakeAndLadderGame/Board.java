package com.home.SnakeAndLadderGame;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Board {
	int size;
	 List<Snake> snakes = new ArrayList<>();
	 List<Ladder> ladders = new ArrayList<>();
	
	public Board(int size) {
		this.size = size;
		Snake s1 = new Snake(9, 2);
		Snake s2 = new Snake(14,3);
		Snake s3 = new Snake(13,10);
		
		Ladder l1 = new Ladder(2, 7);
		Ladder l2 = new Ladder(6, 12);
		
		this.snakes.addAll(Arrays.asList(s1, s2, s3));
		this.ladders.addAll(Arrays.asList(l1, l2));
	}
	
	public int getSize() {
        return size;
    }

	public List<Snake> getSnakes() {
		return snakes;
	}

	public List<Ladder> getLadders() {
		return ladders;
	}
	
}
