package com.home.Splitwise;


public class User {

	int id;
	String name;
	UserExpenseBalanceSheet userExpenseBalanceSheet;
	public User(int id, String name) {
		super();
		this.id = id;
		this.name = name;
		this.userExpenseBalanceSheet =  new UserExpenseBalanceSheet();
	}
	
}
