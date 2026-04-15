package com.home.SnakeAndLadderGame;

public class Cell {
	private int num;
	private int row;
	private int col;
	
	public Cell(int num,int row, int col) {
		super();
		this.num = num;
		this.row = row;
		this.col = col;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getCol() {
		return col;
	}

	public void setCol(int col) {
		this.col = col;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}
}
