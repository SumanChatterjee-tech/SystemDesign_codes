package com.home.ATMDesign;

public class CashWithdrawlState extends ATMState {

	public CashWithdrawlState() {
		System.out.println("In cash withdrawl state");
	}
	
	@Override
	public void cashWithdrawal(ATM atm, Card card, int withdrawAmount) {
		//check if balance is more and fund is sufficiannt in ATM
		CashProcessor cash = new CashProcessor(new OnehundreedProcessor(new TwoHundredProcessor(null)));
		cash.withdraw(atm, withdrawAmount);
		exit(atm);
	}
	
	 @Override
	    public void exit(ATM atmObject) {
	        returnCard();
	        atmObject.setAtmState(new IdleState());
	        System.out.println("Exit happens");
	    }

	    @Override
	    public void returnCard() {
	        System.out.println("Please collect your card");
	    }
}

