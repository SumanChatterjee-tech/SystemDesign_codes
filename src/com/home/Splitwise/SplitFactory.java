package com.home.Splitwise;

public class SplitFactory {
 
	 public static ExpenseSplit getExepenseeTypeSplit(ExpenseType extype) {
		 
		 switch (extype) {
         case EQUAL:
             return new EqualExpenseSplit();
         case UNEQUAL:
             return new UnequalExpenseSplit();
         case PERCENTAGE:
             return new PercentageExpenseSplit();
         default:
             return null;
     }
	 }
}
