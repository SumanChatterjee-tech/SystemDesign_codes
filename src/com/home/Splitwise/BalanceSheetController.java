package com.home.Splitwise;

import java.util.List;

public class BalanceSheetController {

	public void updateUserExpenseBalanceSheet(User paidBy, List<Split> splitList, int totalAmount) {
		
		UserExpenseBalanceSheet userExpenseBalanceSheet = paidBy.userExpenseBalanceSheet;
		userExpenseBalanceSheet.setTotalPayment(userExpenseBalanceSheet.getTotalPayment() + totalAmount);
		
		for(Split sp : splitList) {
			
			User userOwe = sp.user;
			UserExpenseBalanceSheet userOweExpenseBalanceSheet = userOwe.userExpenseBalanceSheet;
			int amount = sp.amount;
			
			if( paidBy.id == userOwe.id) {
				userExpenseBalanceSheet.setTotalYourExpense(userExpenseBalanceSheet.getTotalYourExpense()+amount);
			}else {
				userExpenseBalanceSheet.setTotalYouGetBack(userExpenseBalanceSheet.getTotalYouGetBack()+ amount);
				//update the other users
			}
		}
	}
}
