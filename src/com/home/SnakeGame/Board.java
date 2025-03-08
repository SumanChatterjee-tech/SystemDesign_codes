package com.home.SnakeGame;

public class Board {

	int total_row_cnt;
	int total_col_cnt;
	Cell[][] cell;
	public Board(int total_row_cnt, int total_col_cnt) {

		this.total_row_cnt = total_row_cnt;
		this.total_col_cnt = total_col_cnt;
		this.cell = new Cell[total_row_cnt][total_col_cnt];
		for (int row = 0; row < total_row_cnt; row++) {
            for (int column = 0; column < total_col_cnt;column++) {
                cell[row][column] = new Cell(row, column);
            }
        }
	}
	
	public Cell[][] getCells() { return cell; }
	
	public void generateFood() {
		System.out.println("Generating food");
		int row = 0;
		int col = 0;
		while(true) {
	      row = (int)(Math.random() * total_row_cnt);
          col = (int)(Math.random() * total_col_cnt);
          if(cell[row][col].getCellType() != CellType.SNAKE_NODE) {
        	  cell[row][col].setCellType(CellType.FOOD);
        	  break;
          }
		}
		System.out.println("food generated at, row-"+ row + " and col-"+col);
	}
	
}
