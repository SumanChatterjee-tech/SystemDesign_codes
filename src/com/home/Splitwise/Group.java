package com.home.Splitwise;

import java.util.ArrayList;
import java.util.List;


public class Group {

	int groupId;
	String name;
	List<User> user;
	List<Expense> listofExpense;
	ExpenseController expenseController;
	public Group() {
		this.user = new ArrayList<>();
		this.listofExpense = new ArrayList<>();
		this.expenseController = new ExpenseController();
	}
	
	public Expense createExpense(String expenseId, String description, double expenseAmount,
            List<Split> splitDetails, ExpenseType splitType, User paidByUser) {
		Expense expense =  this.expenseController.createExpense(groupId, description, groupId, splitDetails, splitType, paidByUser);
		this.listofExpense.add(expense);
		return expense;
	}
}
