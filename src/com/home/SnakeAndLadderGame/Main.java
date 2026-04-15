package com.home.SnakeAndLadderGame;

import java.util.Deque;
import java.util.LinkedList;

public class Main {

	public static void main(String[] args) {
		Board board= new Board(16);
		Player p1 = new Player("S1");
		Player p2 = new Player("S2");
		Deque<Player> players = new LinkedList<>();
		players.add(p1);
		players.add(p2);
		Game g = new Game(board, players);
		g.play();
	}

}
