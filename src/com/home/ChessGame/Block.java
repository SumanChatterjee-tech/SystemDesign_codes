package com.home.ChessGame;

public class Block {
	
	int x, y;
	Piece piece;
	public Block(int x, int y, Piece piece) {
		super();
		this.x = x;
		this.y = y;
		this.piece = piece;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public Piece getPiece() {
		return piece;
	}
	public void setPiece(Piece piece) {
		this.piece = piece;
	}
}
