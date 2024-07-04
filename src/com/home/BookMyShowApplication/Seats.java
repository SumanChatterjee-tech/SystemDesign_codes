package com.home.BookMyShowApplication;

public class Seats {
	int id;
	int row;
	CategoryOfSeats category;
	int price;
	public Seats(int id, int row, CategoryOfSeats category, int price) {
		super();
		this.id = id;
		this.row = row;
		this.category = category;
		this.price = price;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getRow() {
		return row;
	}
	public void setRow(int row) {
		this.row = row;
	}
	public CategoryOfSeats getCategory() {
		return category;
	}
	public void setCategory(CategoryOfSeats category) {
		this.category = category;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
}
