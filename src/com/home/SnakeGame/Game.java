package com.home.SnakeGame;

public class Game {

	public static final int DIRECTION_NONE = 0, DIRECTION_RIGHT = 1, DIRECTION_LEFT = 2, DIRECTION_UP = 3,
			DIRECTION_DOWN = 4;
	private Snake snake;
	private Board board;
	private int direction;
	private boolean gameOver;

	public Game(Snake snake, Board board) {
		this.snake = snake;
		this.board = board;
	}

	public Game(Snake snake, Board board, int direction, boolean gameOver) {
		super();
		this.snake = snake;
		this.board = board;
		this.direction = direction;
		this.gameOver = gameOver;
	}
	
	public int getDirection() {
		return direction;
	}

	public void setDirection(int direction) {
		this.direction = direction;
	}

	public boolean isGameOver() {
		return gameOver;
	}

	public void setGameOver(boolean gameOver) {
		this.gameOver = gameOver;
	}

	public void update() {
		while(!this.gameOver) {
			//check for crash
			Cell nextCell = getNextCell(snake.getHead());
			if(nextCell.getRow() == board.total_row_cnt || nextCell.getCol() == board.total_col_cnt) {
				this.gameOver = true;
			}else if(snake.checkCrash(nextCell)) {
				this.gameOver = true;
			}else {
				snake.move(nextCell);
				if(nextCell.cellType == CellType.FOOD) {
					snake.grow();
					board.generateFood();
				}
			}
		}
		System.out.println("Game is over");
	}
	
	private Cell getNextCell(Cell currentPosition)
    {
        System.out.println("Going to find next cell");
        int row = currentPosition.getRow();
        int col = currentPosition.getCol();
 
        if (direction == DIRECTION_RIGHT) {
            col++;
        }
        else if (direction == DIRECTION_LEFT) {
            col--;
        }
        else if (direction == DIRECTION_UP) {
            row--;
        }
        else if (direction == DIRECTION_DOWN) {
            row++;
        }
 
        Cell nextCell = board.getCells()[row][col];
 
        return nextCell;
    }
}
