package com.home.SnakeAndLadderGame;

import java.util.Deque;
import java.util.List;

public class Game {
	Board board;
	Deque<Player> players;
	GameStatus gamestatus;
	Dice dice;
	
	public Game(Board board, Deque<Player> players) {
		super();
		this.board = board;
		this.players = players;
		this.gamestatus = GameStatus.NOT_STARTED;
		this.dice = new Dice(0, 6);
	}
	
	public void play() {
		//basic check
		if(players.size()<2) {
			System.out.println("Minimum player size has to be greater then or equals to 2");
			return;
		}
		this.gamestatus = GameStatus.RUNNING;
        System.out.println("Game started!");
        
        while(this.gamestatus == GameStatus.RUNNING) {
        	Player currPlayer = this.players.poll();
        	int currPos = currPlayer.getPos();
        	
        	//roll the dice
        	int num = this.dice.roll();
        	int nextPos = num+currPos;
        	
        	if(nextPos > board.getSize()) {
        		System.out.println("Not possible");
        		this.players.addFirst(currPlayer); //letting the currnet player to do it again
        		continue;
        	}
        	
        	if (nextPos == board.getSize()) {
                currPlayer.setPos(nextPos);
                this.gamestatus = GameStatus.FINISHED;
                System.out.printf("Hooray! %s reached the final square %d and won!\n", currPlayer.getName(), board.getSize());
                return;
            }
        	
        	if(isLadder(this.board.getLadders(), nextPos)) {
        		int getFinalPos = getFinalPosForLadders(this.board.getLadders(), nextPos);
        		currPlayer.setPos(getFinalPos);
        	}else if(isSnake(this.board.getSnakes(), nextPos)) {
        		int getFinalPos = getFinalPosForSnake(this.board.getSnakes(), nextPos);
        		currPlayer.setPos(getFinalPos);
        	}else {
        		currPlayer.setPos(nextPos);
        	}
        	
        	 if (num == 6) {
                 System.out.printf("%s rolled a 6 and gets another turn!\n", currPlayer.getName());
                 this.players.addFirst(currPlayer);
        	 }
        	 
     		this.players.addLast(currPlayer);
        }
        
	}
	
	private boolean isLadder(List<Ladder> ladders, int pos) {
	  return ladders.stream().anyMatch(l->l.getStart() == pos);
	}
	private boolean isSnake(List<Snake> snakes, int pos) {
	  return snakes.stream().anyMatch(l->l.getStart() == pos);
	}
	 
	private int getFinalPosForSnake(List<Snake> snakes, int pos) {
		return snakes.stream().filter(l->l.getStart() == pos).findAny().orElse(new Snake(0, 0)).getEnd();
	}
	
	private int getFinalPosForLadders(List<Ladder> ladder, int pos) {
		return ladder.stream().filter(l->l.getStart() == pos).findAny().orElse(new Ladder(0, 0)).getEnd();
	}
}
