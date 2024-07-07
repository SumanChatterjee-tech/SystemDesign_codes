package com.home.VendingMachine;


public class ItemShelf {
	Item Items;
	int code;
	boolean soldOut;
	
	public Item getItems() {
		return Items;
	}
	public void setItems(Item items) {
		Items = items;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public boolean isSoldOut() {
		return soldOut;
	}
	public void setSoldOut(boolean soldOut) {
		this.soldOut = soldOut;
	}
	
	
}
