package com.home.ChessGame;

public class Move {
	Block sourceBlock;
	Block endBlock;
	public Move(Block sourceBlock, Block endBlock) {
		super();
		this.sourceBlock = sourceBlock;
		this.endBlock = endBlock;
	}
	
	public boolean isValid() {
		return !(sourceBlock.getPiece().white == endBlock.getPiece().white);
	}

	public Block getSourceBlock() {
		return sourceBlock;
	}

	public void setSourceBlock(Block sourceBlock) {
		this.sourceBlock = sourceBlock;
	}

	public Block getEndBlock() {
		return endBlock;
	}

	public void setEndBlock(Block endBlock) {
		this.endBlock = endBlock;
	}
}
