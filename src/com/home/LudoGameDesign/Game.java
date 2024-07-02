package com.home.LudoGameDesign;

import java.util.*;


public class Game {

	Board board;
	Deque<Player> players;
	Dice dice;
	Player winner;
	public Game() {
		super();
		intializeBoard();
	}
	
	public void intializeBoard() {
		Board board = new Board(5, 2, 2);
		Dice dice = new Dice(1);
		winner = null;
		
		Player p1 = new Player(1, 0);
		Player p2 = new Player(2, 0);
		
		players.add(p1);
		players.add(p2);
	}
	
	public void startGame() {
		while(winner == null) {
			 Player playerTurn = findPlayerTurn();
			 System.out.println("Current player is"+ playerTurn.id+" with position "+ playerTurn.currentPositon);
			 int pos = dice.rollDice();
			 
			 int newPosition = playerTurn.currentPositon+pos;
			 newPosition = jumpCheck(newPosition);
			 playerTurn.currentPositon = newPosition;
			 
			 System.out.println("player turn is:" + playerTurn.id + " new Position is: " + newPosition);
			 
			 if(newPosition >= board.cells.length* board.cells.length) {
				 winner = playerTurn;
			 }
		}
		System.out.println("We have an winner"+ winner.id);
	}
	
	public Player findPlayerTurn() {
		Player currentPlayer = players.removeFirst();
		players.addLast(currentPlayer);
		return currentPlayer;
	}
	
	public int jumpCheck(int currPos) {
		if(currPos == board.cells.length* board.cells.length) {
			return currPos;
		}
		Cells c = board.getCell(currPos);
		if(c.jump != null && c.jump.start == currPos) {
			 String jumpBy = (c.jump.start < c.jump.end)? "ladder" : "snake";
			 System.out.println("jump done by: " + jumpBy);
			 return c.jump.end;
		}
		return currPos;
	}
}
