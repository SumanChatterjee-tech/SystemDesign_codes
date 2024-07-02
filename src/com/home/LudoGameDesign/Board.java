package com.home.LudoGameDesign;

import java.util.Random;

public class Board {
	Cells[][] cells;

	public Board( int boardsize, int numberOfSnakes, int numberofLadders) {
		this.cells = new Cells[boardsize][boardsize];
		addSnakes(numberOfSnakes);
		addladder(numberofLadders);
	}
	
	public void addSnakes(int numberOfSnakes) {
		Random rand = new Random();
		while(numberOfSnakes >0) {
			int start = rand.nextInt(4);
			int end = rand.nextInt();
			if(start <= end) {
				continue;
			}
			Cells cell = getCell(start);
			cell.jump.start =start;
			cell.jump.end = end;
			
			numberOfSnakes--;
		}
	}
	
	public void addladder(int numberOfSnakes) {
		Random rand = new Random();
		while(numberOfSnakes >0) {
			int start = rand.nextInt(4);
			int end = rand.nextInt();
			if(start >= end) {
				continue;
			}
			Cells cell = getCell(start);
			cell.jump.start =start;
			cell.jump.end = end;
			
			numberOfSnakes--;
		}
	}
	
    Cells getCell(int playerPosition) {
        int boardRow = playerPosition / cells.length;
        int boardColumn = (playerPosition % cells.length);
        return cells[boardRow][boardColumn];
    }
}
