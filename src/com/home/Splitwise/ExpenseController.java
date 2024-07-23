package com.home.Splitwise;

import java.util.List;

public class ExpenseController {
	
	BalanceSheetController balanceSheetController;

	public ExpenseController() {
		this.balanceSheetController = new BalanceSheetController();
	}
	
	public Expense createExpense(int expenseId, String description, int expenseAmount,
			List<Split> splitDetails, ExpenseType splitType, User paidByUser) {
		
		ExpenseSplit expenseSplit = SplitFactory.getExepenseeTypeSplit(splitType);
        expenseSplit.validateRequest(splitDetails, expenseAmount);

        Expense expense = new Expense(expenseId, description, expenseAmount, paidByUser, splitType, splitDetails);

        balanceSheetController.updateUserExpenseBalanceSheet(paidByUser, splitDetails, expenseAmount);

        return expense;
	}
}
