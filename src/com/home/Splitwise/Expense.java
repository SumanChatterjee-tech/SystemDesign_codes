package com.home.Splitwise;

import java.util.ArrayList;
import java.util.List;

public class Expense {

	int id;
	String description;
	int amount;
	User paidBy;
	ExpenseType expenseType;
	List<Split> spiltList = new ArrayList<>();
	
	public Expense(int id, String description, int amount, User paidBy, ExpenseType expenseType,
			List<Split> spiltList) {
		super();
		this.id = id;
		this.description = description;
		this.amount = amount;
		this.paidBy = paidBy;
		this.expenseType = expenseType;
		this.spiltList.addAll(spiltList);
	}
}
