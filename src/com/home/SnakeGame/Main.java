package com.home.SnakeGame;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//default starting direction is right
		int userInp = 0;
		
		Board board = new Board(10, 10);
		Cell inPos = new Cell(0,0);
		Snake snake = new Snake(inPos);
		Game game = new Game(snake, board);
		game.setDirection(1);
		game.setGameOver(false);
		game.update();
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Please input a direction");
		userInp = sc.nextInt();
		//time out is 100000
		for(int i=0;i<10000;i++) {
			if(userInp != 0) {
				game.setDirection(userInp);
				game.update();
			}
		}
	}

}
