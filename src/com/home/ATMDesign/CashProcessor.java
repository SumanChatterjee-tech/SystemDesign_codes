package com.home.ATMDesign;

public class CashProcessor {

	CashProcessor nextcashProcessor;

	public CashProcessor(CashProcessor nextcashProcessor) {
		this.nextcashProcessor = nextcashProcessor;
	}
	
	public void withdraw(ATM atm, int remainingamount) {
		if(this.nextcashProcessor != null) {
			nextcashProcessor.withdraw(atm, remainingamount);
		}
	}
}
