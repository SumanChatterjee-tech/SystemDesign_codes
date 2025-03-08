package com.home.SnakeGame;

import java.util.LinkedList;

public class Snake {

	LinkedList<Cell> ll = new LinkedList<>();
	Cell head;

	public Snake(Cell intPos) {
		head = intPos;
		ll.add(intPos);
		head.setCellType(CellType.SNAKE_NODE);
	}

	public void grow() {
		ll.add(head);
	}

	public void move(Cell nextCell) {
		System.out.println("Going to the next cell");
		Cell lastOfLL = ll.removeLast();
		lastOfLL.setCellType(CellType.EMPTY);

		head = nextCell;
		head.setCellType(CellType.SNAKE_NODE);
		ll.addFirst(head);
	}

	public boolean checkCrash(Cell nextCell) {
		System.out.println("Going to check for Crash");
		for (Cell cell : ll) {
			if (cell == nextCell) {
				return true;
			}
		}

		return false;
	}
	public Cell getHead() { return head; }
	public void setHead(Cell head) { this.head = head; }
}
