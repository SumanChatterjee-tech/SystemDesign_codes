package com.home.ChessGame;

public abstract class Piece {
	boolean white;
	boolean killed=false;
	
	public abstract boolean canMove(Board board, Block start, Block end);

	public Piece(boolean white) {
		super();
		this.white = white;
	}

	public boolean isKilled() {
		return killed;
	}

	public void setKilled(boolean killed) {
		this.killed = killed;
	}
}
