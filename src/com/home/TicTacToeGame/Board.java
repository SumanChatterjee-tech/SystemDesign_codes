package com.home.TicTacToeGame;

import java.util.*;

public class Board {
	int size;
	PlayingPiece[][] board;
	public Board(int size) {
		this.size = size;
		board = new PlayingPiece[size][size];
	}
	
	public void printBoard() {
		for(int i=0;i<size;i++) {
			for(int j=0;j<size;j++) {
				if(board[i][j] != null) {
					System.out.print(board[i][j].pieceType.name()+ "   ");
				}else {
					System.out.print("    ");
				}
				System.out.print(" | ");
			}
			System.out.println("    ");
		}
	}
	
	public Map<Integer, List<Integer>> getFreeSpaces(){
		Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
		for(int i=0;i<size;i++) {
			map.put(i, new ArrayList<Integer>());
			for(int j=0;j<size;j++) {
				List<Integer> l = map.get(i);
				if(board[i][j] == null) {
					l.add(j);
					map.put(i, l);
				}
			}
		}
		return map;
	}
	
	public boolean addPiece(int row, int col, PlayingPiece piece) {
	        board[row][col] = piece;
	        return true;
	}
}
