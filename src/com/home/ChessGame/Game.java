package com.home.ChessGame;

import java.util.ArrayList;

public class Game {
	Board board;
	Player player1;
	Player player2;
	Status status;
	ArrayList<Move> gameLog;
	boolean isWhiteRun;
	public Game(Board board, Player player1, Player player2, Status status, ArrayList<Move> gameLog,
			boolean isWhiteRun) {
		super();
		this.board = new Board();
		this.player1 = player1;
		this.player2 = player2;
		this.status = Status.ACTIVE;
		this.gameLog = new ArrayList<>();
		this.isWhiteRun = isWhiteRun;
	}
	
	public void start() {
		while(this.status == Status.ACTIVE) {
			// player1 will make the move if its white's turn
            // else player2 will make the move
            if(isWhiteRun){
            	//start and end block will get it from user
                //makeMove(new Move(startBlock,endBlock),player1);
            }
            else{
                //makeMove(new Move(startBlock,endBlock),player2);
            }
		}
	}
	
	public void makeMove(Move move, Player player1) {
		
		if(move.isValid()) {
			Piece sourcePiece = move.sourceBlock.getPiece();
			if(sourcePiece.canMove(board, move.sourceBlock, move.endBlock)) {
				Piece endPiece = move.endBlock.getPiece();
				if(endPiece !=null) {
					if(endPiece instanceof King && isWhiteRun) {
						this.status = Status.WHITE_WIN;
						return;
					}else if(endPiece instanceof King && !isWhiteRun) {
						this.status = Status.BLACK_WIN;
						return;
					}
					
					endPiece.setKilled(true);
				}
				
				gameLog.add(move);
				move.getSourceBlock().setPiece(null);
				move.getEndBlock().setPiece(sourcePiece);
				isWhiteRun = !isWhiteRun;
			}
		}
	}
}
