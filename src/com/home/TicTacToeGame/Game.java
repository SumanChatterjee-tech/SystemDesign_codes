package com.home.TicTacToeGame;

import java.util.*;


public class Game {
	
	Deque<Players> players;
	Board playBoard;
	Scanner sc = new Scanner(System.in);
	public Game() {
		players = new LinkedList<>();
		
		PlayingPieceX px = new PlayingPieceX();
		Players p1 = new Players("px", px);
		
		PlayingPieceO po = new PlayingPieceO();
		Players p2 = new Players("po", po);
		
		players.add(p1);
		players.add(p2);
		
		this.playBoard = new Board(3);
	}
	
	public void startGame() {
		boolean isAWinner=true;
		while(isAWinner) {
			Players p = players.removeFirst();
			
			//print the board
			playBoard.printBoard();
			System.out.print("Play the game, player :"+p.name+" please input postions");
		    String s = sc.nextLine();
            String[] values = s.split(",");
            int inputRow = Integer.valueOf(values[0]);
            int inputColumn = Integer.valueOf(values[1]);
            
            Map<Integer, List<Integer>> check= playBoard.getFreeSpaces();
            boolean isFreeSpaceAvailable = true;
            for(Map.Entry<Integer, List<Integer>> m: check.entrySet()) {
            	List<Integer> temp = m.getValue();
            	if(temp.isEmpty()) {
            		isFreeSpaceAvailable = false;
            		break;
            	}
            }
            if(!isFreeSpaceAvailable) {
            	isAWinner = isFreeSpaceAvailable;
            	continue;
            }
            if(!check.containsKey(inputRow)) {
            	System.out.println("Invalid Row Try Again");
    			players.addFirst(p);
    			continue;
            }
            for(Map.Entry<Integer, List<Integer>> m: check.entrySet()) {
            	if(m.getKey() == inputRow) {
            		List<Integer> list = m.getValue();
            		if(!list.contains(inputColumn)) {
            			System.out.println("Invalid col Try Again");
            			players.addFirst(p);
            			continue;
            		}
            	}
            }
            
            if(playBoard.addPiece(inputRow, inputColumn, p.playingPiece)) {
            	players.addLast(p);
            	if(isThereWinner(inputRow, inputColumn, p.playingPiece.pieceType)) {
            		System.out.println("Winner is:"+ p.name);
            		break;
            	}
            }
		}
		
		System.out.println("Match is a tie");
	}
	
	public boolean isThereWinner(int row, int column, PieceType pieceType) {

        boolean rowMatch = true;
        boolean columnMatch = true;
        boolean diagonalMatch = true;
        boolean antiDiagonalMatch = true;

        //need to check in row
        for(int i=0;i<playBoard.size;i++) {

            if(playBoard.board[row][i] == null || playBoard.board[row][i].pieceType != pieceType) {
                rowMatch = false;
            }
        }

        //need to check in column
        for(int i=0;i<playBoard.size;i++) {

            if(playBoard.board[i][column] == null || playBoard.board[i][column].pieceType != pieceType) {
                columnMatch = false;
            }
        }

        //need to check diagonals
        for(int i=0, j=0; i<playBoard.size;i++,j++) {
            if (playBoard.board[i][j] == null || playBoard.board[i][j].pieceType != pieceType) {
                diagonalMatch = false;
            }
        }

        //need to check anti-diagonals
        for(int i=0, j=playBoard.size-1; i<playBoard.size;i++,j--) {
            if (playBoard.board[i][j] == null || playBoard.board[i][j].pieceType != pieceType) {
                antiDiagonalMatch = false;
            }
        }

        return rowMatch || columnMatch || diagonalMatch || antiDiagonalMatch;
    }
	
}
